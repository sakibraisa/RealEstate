/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.City;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InCityDao {
   List<City> getAllObject();

    City getObjectById(int id);

    void addObject(City obj);

    void updateObject(City obj);

    void deleteObject(int id);

    boolean objectExists(City obj); 
}
