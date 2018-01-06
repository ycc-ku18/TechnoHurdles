/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.controller;

import com.hurdles.agroNepal.model.Product;
import com.hurdles.agroNepal.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Perfect Sudip
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductRepository productRepo;
    
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }
    
    @RequestMapping(value = "/getProductById/{id}",method=RequestMethod.GET)
    public Product getProductById(@PathVariable Long id){
        return productRepo.findOne(id);
    }
    
    @RequestMapping(value ="/getProductsByRegion/{id}",method = RequestMethod.GET)
    public List<Product> getRegiontId(@PathVariable Integer id){
        return productRepo.findProductByRegion(id);
    }
//    @RequestMapping(value ="/getByRegName/{name}",method = RequestMethod.GET)
//    public List<Product> getRegiontName(@PathVariable String name){
//        return productRepo.findProductByRegionName(name);
//    }
//     @RequestMapping(value ="/getByName/{name}",method = RequestMethod.GET)
//    public List<Product> getproductName(@PathVariable String name){
//        return productRepo.findProductByName(name);
//    }
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        productRepo.save(product);
    }
}
