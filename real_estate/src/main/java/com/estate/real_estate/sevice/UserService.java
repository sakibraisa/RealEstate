/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InUserDao;
import com.estate.real_estate.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class UserService implements InUserService{
    @Autowired
    private InUserDao InUserDao;

    @Override
    public List<User> getAllObject() {
        return InUserDao.getAllObject();
    }

    @Override
    public User getObjectById(int id) {
        User obj= InUserDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(User obj) {
        InUserDao.addObject(obj);
    }

    @Override
    public void updateObject(User obj) {
        InUserDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InUserDao.deleteObject(id);
    }
    
}
