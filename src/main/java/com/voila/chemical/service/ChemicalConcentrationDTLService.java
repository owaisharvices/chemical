package com.voila.chemical.service;

import com.voila.chemical.dao.ChemicalConcentrationDTLRepository;
import com.voila.chemical.dao.ChemicalMSTRepository;
import com.voila.chemical.model.ChemicalConcentrationDTL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalConcentrationDTLService {

    @Autowired
    private ChemicalConcentrationDTLRepository repository;
    @Autowired
    private ChemicalMSTRepository chemicalMSTRepository;



    public ChemicalConcentrationDTL create(ChemicalConcentrationDTL chemicalConcentrationDTL) throws Exception {

        chemicalConcentrationDTL.setChemicalMST(chemicalMSTRepository.findById(chemicalConcentrationDTL.getChemicalMSTId()).orElseThrow(()->new Exception("Chemical not found")));
        repository.findByTradeNameIgnoreCaseAndConcentrationAndChemicalMSTIdAndGradeIgnoreCase(chemicalConcentrationDTL.getTradeName(),chemicalConcentrationDTL.getConcentration(),chemicalConcentrationDTL.getChemicalMSTId(),chemicalConcentrationDTL.getGrade()).ifPresent(x->{
            throw new RuntimeException("Chemical Concentration Already Present!");
        });
        return repository.save(chemicalConcentrationDTL);
    }

    public ChemicalConcentrationDTL update(ChemicalConcentrationDTL chemicalConcentrationDTL) throws Exception {

        repository.findById(chemicalConcentrationDTL.getId()).orElseThrow(()->new Exception("chemical Concentration not found"));
        chemicalConcentrationDTL.setChemicalMST(chemicalMSTRepository.findById(chemicalConcentrationDTL.getChemicalMSTId()).orElseThrow(()->new Exception("Chemical not found")));
        repository.findByTradeNameIgnoreCaseAndConcentrationAndChemicalMSTIdAndGradeIgnoreCase(chemicalConcentrationDTL.getTradeName(),chemicalConcentrationDTL.getConcentration(),chemicalConcentrationDTL.getChemicalMSTId(),chemicalConcentrationDTL.getGrade()).ifPresent(x->{
           if(!x.getId().equals(chemicalConcentrationDTL.getId()))
               throw new RuntimeException("Chemical Concentration Already Present!");
        });
        return repository.save(chemicalConcentrationDTL);
    }

    public List<ChemicalConcentrationDTL> findByChemicalMSTIdAndConcentration(Long chemicalMSTId,Double concentration)
    {
        return repository.findByChemicalMSTIdAndConcentration(chemicalMSTId,concentration);
    }


}
