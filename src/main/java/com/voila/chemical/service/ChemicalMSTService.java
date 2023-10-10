package com.voila.chemical.service;

import com.voila.chemical.dao.ChemicalMSTRepository;
import com.voila.chemical.model.ChemicalMST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalMSTService {

    @Autowired
    private ChemicalMSTRepository repository;

    public ChemicalMST create(ChemicalMST chemicalMST)
    {
        repository.findByChemicalNameIgnoreCase(chemicalMST.getChemicalName()).ifPresent(x->{
            throw new RuntimeException("Chemical Already present");
        });
        return repository.save(chemicalMST);
    }

    public ChemicalMST update(ChemicalMST chemicalMST)
    {
        repository.findByChemicalNameIgnoreCase(chemicalMST.getChemicalName()).ifPresent(x->{
            if(!x.getId().equals(chemicalMST.getId()))
                throw new RuntimeException("Chemical Already present");
        });
        return repository.save(chemicalMST);
    }

    public ChemicalMST findByChemicalName(String name) throws Exception
    {
        return repository.findByChemicalNameIgnoreCase(name).orElseThrow(()->new Exception("Chemical Not Found"));
    }

    public List<ChemicalMST> getAll()
    {
        return  repository.findAll();
    }




}
