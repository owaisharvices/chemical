package com.voila.chemical.dao;

import com.voila.chemical.model.ChemicalConcentrationDTL;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ChemicalConcentrationDTLRepository extends JpaRepository<ChemicalConcentrationDTL,Long> {


    Optional<ChemicalConcentrationDTL> findByTradeNameIgnoreCaseAndConcentrationAndChemicalMSTIdAndGradeIgnoreCase(String tradeName,Double concentration,Long chemicalMSTId,String grade);


    List<ChemicalConcentrationDTL> findByChemicalMSTIdAndConcentration(Long chemicalMSTId,Double concentration);

    List<ChemicalConcentrationDTL> findByChemicalMSTId(Long id);
}
