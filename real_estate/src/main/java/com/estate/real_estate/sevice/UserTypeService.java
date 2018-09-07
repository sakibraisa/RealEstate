/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InUserTypeDao;
import com.estate.real_estate.domain.UserType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class UserTypeService implements InUserTypeService{
    @Autowired
    private InUserTypeDao InUserTypeDao;

    @Override
    public List<UserType> getAllObject() {
        return InUserTypeDao.getAllObject();
    }

    @Override
    public UserType getObjectById(int id) {
        UserType obj= InUserTypeDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(UserType obj) {
        InUserTypeDao.addObject(obj);
    }

    @Override
    public void updateObject(UserType obj) {
        InUserTypeDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InUserTypeDao.deleteObject(id);
    }
}
