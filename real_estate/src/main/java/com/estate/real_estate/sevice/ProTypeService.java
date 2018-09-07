/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InProTypeDao;
import com.estate.real_estate.domain.ProType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class ProTypeService implements InProTypeService{
    @Autowired
    private InProTypeDao InProTypeDao;

    @Override
    public List<ProType> getAllObject() {
        return InProTypeDao.getAllObject();
    }

    @Override
    public ProType getObjectById(int id) {
        ProType obj= InProTypeDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(ProType obj) {
        InProTypeDao.addObject(obj);
    }

    @Override
    public void updateObject(ProType obj) {
        InProTypeDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InProTypeDao.deleteObject(id);
    }

}
