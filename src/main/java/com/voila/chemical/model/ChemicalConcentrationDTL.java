package com.voila.chemical.model;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;

@Entity
@Table(name = "checmical_concentration_dtl")
public class ChemicalConcentrationDTL extends  BaseModel{


    @ManyToOne
    @JoinColumn(name = "chemical_mst_id")
    ChemicalMST chemicalMST;

    @Column(name = "chemical_mst_id",insertable = false,updatable = false)
    Long chemicalMSTId;

    @Column(name = "common_name")
    String commonName;

    @Column(name = "trade_name")
    String tradeName;

    @Column(name = "material_code")
    String materialCode;

    @Column(name = "grade")
    String grade;

    @Column(name = "grade_name")
    String gradeName;

    @Column(name = "concentration")
    Double concentration;

    @Column(name = "header")
    String header;

    public ChemicalMST getChemicalMST() {
        return chemicalMST;
    }

    public void setChemicalMST(ChemicalMST chemicalMST) {
        this.chemicalMST = chemicalMST;
    }

    public Long getChemicalMSTId() {
        return chemicalMSTId;
    }

    public void setChemicalMSTId(Long chemicalMSTId) {
        this.chemicalMSTId = chemicalMSTId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Double getConcentration() {
        return concentration;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }
}
