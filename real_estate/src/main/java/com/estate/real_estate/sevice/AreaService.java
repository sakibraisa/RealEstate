/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;


import com.estate.real_estate.dao.InAreaDao;
import com.estate.real_estate.domain.Area;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author C6
 */
@Service
public class AreaService implements InAreaService{

    @Autowired
    private InAreaDao InAreaDao;
    
    @Override
    public List<Area> getAllObject() {
        return InAreaDao.getAllObject();
    }

    @Override
    public Area getObjectById(int id) {
       Area obj= InAreaDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(Area obj) {
        InAreaDao.addObject(obj);
    }

    @Override
    public void updateObject(Area obj) {
        InAreaDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InAreaDao.deleteObject(id);
    }
    
}
