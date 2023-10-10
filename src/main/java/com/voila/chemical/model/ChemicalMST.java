package com.voila.chemical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chemical_mst")
public class ChemicalMST extends BaseModel {

    @Column(name = "chemical_name")
    String chemicalName;

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }
}
