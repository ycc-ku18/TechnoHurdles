/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.controller;

import com.hurdles.agroNepal.model.Shop;
import com.hurdles.agroNepal.repository.ShopRepository;
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
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopRepository shopRepo;
    
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Shop> getAllShop(){
        return shopRepo.findAll();
    }
    
       
    @RequestMapping(value = "/getShopById/{id}",method = RequestMethod.GET)
    public Shop getShopById(@PathVariable Long id){
        return shopRepo.findOne(id);
    }
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void addShop(@RequestBody Shop shop){
        shopRepo.save(shop);
    }
    @RequestMapping(value = "/getShopsByRegion/{regId}",method = RequestMethod.GET)
    public List<Shop> getShopByregion(@PathVariable Integer regId){
        return shopRepo.findByRegion(regId);
    }
}
