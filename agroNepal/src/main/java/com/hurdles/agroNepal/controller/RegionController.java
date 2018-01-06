/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.controller;

import com.hurdles.agroNepal.model.Region;
import com.hurdles.agroNepal.repository.RegionRepository;
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
@RequestMapping("/region")
public class RegionController {
    
    @Autowired
    RegionRepository regionRepo;
    
 
    
     @RequestMapping(value = "/getAllRegions",method = RequestMethod.GET)
    public List<Region> getAllRegion(){  
        return regionRepo.findAll();
    }
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void addRegion(@RequestBody Region region){
        regionRepo.save(region);
    }
}
