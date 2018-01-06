/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.repository;

import com.hurdles.agroNepal.model.Shop;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Perfect Sudip
 */
public interface ShopRepository extends JpaRepository<Shop, Long>{
    @Query("SELECT s FROM Shop s, Region r WHERE s.shopRegId=r.regId AND r.regId= :id")
    public List<Shop> findByRegion(@Param("id") Integer id);
        
    
}
