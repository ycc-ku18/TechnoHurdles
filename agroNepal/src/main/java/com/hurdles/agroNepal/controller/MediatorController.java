/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.controller;

import com.hurdles.agroNepal.model.Mediator;
import com.hurdles.agroNepal.repository.MediatorRepository;
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
@RequestMapping("/mediator")
public class MediatorController {
    @Autowired
    MediatorRepository mediatorRepo;
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void addUser(@RequestBody Mediator mediator){
         mediatorRepo.save(mediator);
    }
    
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Mediator> getAllMediator(){  
        return mediatorRepo.findAll();
    }
    
     @RequestMapping(value ="/getMediatorsByRegion/{id}",method = RequestMethod.GET)
    public List<Mediator> getByRegion(@PathVariable Integer id){
        return mediatorRepo.findMediatorsByRegion(id);
    }
}
