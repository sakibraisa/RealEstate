/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.UserType;
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
public class UserTypeDao implements InUserTypeDao{
    
  @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<UserType> getAllObject() {
        String hql = "FROM UserType as p ORDER BY p.userTypeId";
        return (List<UserType>) hibernateTemplate.find(hql);
    }

    @Override
    public UserType getObjectById(int id) {
        return hibernateTemplate.get(UserType.class, id);
    }

    @Override
    public void addObject(UserType obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(UserType obj) {
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(UserType obj) {
 String hql = "FROM UserType as p WHERE p.userType = ?";
        List<UserType> userType = (List<UserType>) hibernateTemplate.find(hql, obj);
        return userType.size() > 0 ? true : false;    }   
}
