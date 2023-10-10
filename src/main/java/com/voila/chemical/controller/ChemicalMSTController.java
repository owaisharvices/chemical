package com.voila.chemical.controller;

import com.voila.chemical.model.ChemicalMST;
import com.voila.chemical.service.ChemicalMSTService;
import com.voila.chemical.util.Constants;
import com.voila.chemical.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("chemicalMST/")
public class ChemicalMSTController {

    @Autowired
    private ChemicalMSTService service;

    @PostMapping(value = Constants.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse create(@Valid @RequestBody ChemicalMST chemicalMST) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.create(chemicalMST));
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
    public GenericResponse update(@Valid @RequestBody ChemicalMST chemicalMST) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.update(chemicalMST));
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


    @GetMapping(value = Constants.ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse all() {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(service.getAll());
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
