package com.voila.chemical.dao;

import com.voila.chemical.model.ChemicalMST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChemicalMSTRepository extends JpaRepository<ChemicalMST,Long> {

    Optional<ChemicalMST> findByChemicalNameIgnoreCase(String chemicalName);
}
