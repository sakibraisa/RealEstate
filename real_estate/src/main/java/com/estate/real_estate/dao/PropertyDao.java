/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Property;
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
public class PropertyDao implements InPropertyDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Property> getAllObject() {
        String hql = "FROM Property p LEFT JOIN FETCH  p.proType LEFT JOIN FETCH  p.city LEFT JOIN FETCH  p.area ORDER BY p.proId";
        return (List<Property>) hibernateTemplate.find(hql);
    }

    @Override
    public Property getObjectById(int id) {
        return hibernateTemplate.get(Property.class, id);
    }

    @Override
    public void addObject(Property obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Property obj) {
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Property obj) {
 String hql = "FROM Property as p WHERE p.proName = ?";
        List<Property> property = (List<Property>) hibernateTemplate.find(hql, obj);
        return property.size() > 0 ? true : false;    }
}
