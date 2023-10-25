package com.voila.chemical.service;

import com.voila.chemical.dao.ChemicalConcentrationDTLRepository;
import com.voila.chemical.dao.ChemicalMSTRepository;
import com.voila.chemical.model.ChemicalConcentrationDTL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Map findByChemicalMSTIdAndConcentration(Long chemicalMSTId,Double concentration)
    {
       Map<String,List<ChemicalConcentrationDTL>> map= repository.findByChemicalMSTIdAndConcentration(chemicalMSTId,concentration).stream().collect(Collectors.groupingBy(ChemicalConcentrationDTL::getHeader));
    return map;
    }


    public Set<Double> getAllChemicalConcentrationByChemicalMSTId(Long chemicalMSTId)
    {
       return repository.findByChemicalMSTId(chemicalMSTId).stream().map(ChemicalConcentrationDTL::getConcentration).collect(Collectors.toSet());
    }


}
