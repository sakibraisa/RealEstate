/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author C6
 */
@Transactional
@Repository
public class UserDao implements InUserDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<User> getAllObject() {
        String hql = "FROM User p LEFT JOIN FETCH  p.userType ORDER BY p.userId";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public User getObjectById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public void addObject(User obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(User obj) {
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(User obj) {
 String hql = "FROM User as p WHERE p.fname = ?";
        List<User> user = (List<User>) hibernateTemplate.find(hql, obj);
        return user.size() > 0 ? true : false;    }
    
}
