/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.repository;

import com.hurdles.agroNepal.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Perfect Sudip
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p,Region r where p.prodRegId=r.regId AND r.regId= :rId ")
    public List<Product> findProductByRegion(@Param("rId") Integer rId);

//    @Query("SELECT p from Product p,Region r where p.prodRegId=r.regId AND r.regName= :rName ")
//    public List<Product> findProductByRegionName(@Param("rName") String rName);
    
     @Query("SELECT p from Product p,Region r where p.prodName= :pName ")
    public List<Product> findProductByName(@Param("pName") String pName);
}
