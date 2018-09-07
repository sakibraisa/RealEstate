/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InCityDao;
import com.estate.real_estate.domain.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService implements InCityService {

    
    @Autowired
    private InCityDao InCityDao;
    
    @Override
    public List<City> getAllObject() {
        return InCityDao.getAllObject();
    }

    @Override
    public City getObjectById(int id) {
        City obj = InCityDao.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(City obj) {
       InCityDao.addObject(obj);
       return true;
    }

    @Override
    public void updateObject(City obj) {
        InCityDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InCityDao.deleteObject(id);
    }
    
}
