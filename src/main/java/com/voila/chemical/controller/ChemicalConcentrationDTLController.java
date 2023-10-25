package com.voila.chemical.controller;

import com.voila.chemical.model.ChemicalConcentrationDTL;
import com.voila.chemical.model.ChemicalMST;
import com.voila.chemical.service.ChemicalConcentrationDTLService;
import com.voila.chemical.util.Constants;
import com.voila.chemical.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("chemicalConcentrationDTL/")
public class ChemicalConcentrationDTLController {


    @Autowired
    private ChemicalConcentrationDTLService service;

    @PostMapping(value = Constants.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse create(@Valid @RequestBody ChemicalConcentrationDTL chemicalConcentrationDTL) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.create(chemicalConcentrationDTL));
            genericResponse.setMessage("SuccessFul");
            genericResponse.setStatus(true);
            return genericResponse;
        } catch (Exception e) {
            e.printStackTrace();
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
            return genericResponse;
        }
    }

    @PutMapping(value = Constants.UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse update(@Valid @RequestBody ChemicalConcentrationDTL chemicalConcentrationDTL) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.update(chemicalConcentrationDTL));
            genericResponse.setMessage("SuccessFul");
            genericResponse.setStatus(true);
            return genericResponse;
        } catch (Exception e) {
            e.printStackTrace();
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
            return genericResponse;
        }
    }


    @GetMapping(value = "byChemicalMSTIdAndConcentration/" + "{chemicalMSTId}/{concentration}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse byId(@PathVariable(value = "chemicalMSTId") Long chemicalMSTId,@PathVariable(value = "concentration") Double concentration) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.findByChemicalMSTIdAndConcentration(chemicalMSTId,concentration));
            genericResponse.setMessage("SuccessFul");
            genericResponse.setStatus(true);
            return genericResponse;
        } catch (Exception e) {
            e.printStackTrace();
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
            return genericResponse;
        }
    }

    @GetMapping(value = "concentrationByChemicalMSTId/" + "{chemicalMSTId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse concentrationByChemicalMSTId(@PathVariable(value = "chemicalMSTId") Long chemicalMSTId) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.getAllChemicalConcentrationByChemicalMSTId(chemicalMSTId));
            genericResponse.setMessage("SuccessFul");
            genericResponse.setStatus(true);
            return genericResponse;
        } catch (Exception e) {
            e.printStackTrace();
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
            return genericResponse;
        }
    }


}
