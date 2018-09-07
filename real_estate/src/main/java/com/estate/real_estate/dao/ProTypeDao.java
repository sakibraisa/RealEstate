/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.ProType;
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
public class ProTypeDao implements InProTypeDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<ProType> getAllObject() {
        String hql = "FROM ProType as p ORDER BY p.proTypeId";
        return (List<ProType>) hibernateTemplate.find(hql);
    }

    @Override
    public ProType getObjectById(int id) {
        return hibernateTemplate.get(ProType.class, id);
    }

    @Override
    public void addObject(ProType obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(ProType obj) {
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(ProType obj) {
 String hql = "FROM ProType as p WHERE p.proType = ?";
        List<ProType> proType = (List<ProType>) hibernateTemplate.find(hql, obj);
        return proType.size() > 0 ? true : false;    }
    
}
