/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.repository;

import com.hurdles.agroNepal.model.Mediator;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Perfect Sudip
 */
public interface MediatorRepository extends JpaRepository<Mediator, Long> {

    @Query("SELECT p FROM Mediator p WHERE p.medRegId.regId = :rId")
    public List<Mediator> findMediatorsByRegion(@Param("rId") Integer rId);
}
