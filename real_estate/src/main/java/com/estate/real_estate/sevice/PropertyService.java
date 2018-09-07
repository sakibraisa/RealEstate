/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InPropertyDao;
import com.estate.real_estate.domain.Property;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class PropertyService implements InPropertyService{
    @Autowired
    private InPropertyDao InPropertyDao;

    @Override
    public List<Property> getAllObject() {
    return InPropertyDao.getAllObject();
    }

    @Override
    public Property getObjectById(int id) {
    Property obj= InPropertyDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(Property obj) {
    InPropertyDao.addObject(obj);
    }

    @Override
    public void updateObject(Property obj) {
    InPropertyDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
    InPropertyDao.deleteObject(id);
    }
    
}
