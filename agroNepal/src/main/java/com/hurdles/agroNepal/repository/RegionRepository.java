/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.repository;

import com.hurdles.agroNepal.model.Region;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Perfect Sudip
 */
public interface RegionRepository extends JpaRepository<Region, Integer>{
    
}
