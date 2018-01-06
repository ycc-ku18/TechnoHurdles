/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.repository;

import com.hurdles.agroNepal.model.Profile;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Perfect Sudip
 */
public interface ProfileRepository extends JpaRepository<Profile, Long>{
    @Query("SELECT p FROM Profile p  ORDER BY p.id")
    public List<Profile> findFew(Pageable page);
}
