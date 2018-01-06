/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.controller;

import com.hurdles.agroNepal.model.Profile;
import com.hurdles.agroNepal.repository.ProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileRepository profileRepo;
    
    @RequestMapping( value = "/getProfiles" ,method = RequestMethod.GET )
    public List<Profile> getFewProfile(){
      return  profileRepo.findFew(new PageRequest(0, 5));
    }
    
    @RequestMapping(value = "/getProfileById/{id}", method = RequestMethod.GET)
    public Profile getById(@PathVariable Long id){
        return profileRepo.findOne(id);
    }
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void addProfile(@RequestBody Profile profile){
        profileRepo.save(profile);
    }
}
