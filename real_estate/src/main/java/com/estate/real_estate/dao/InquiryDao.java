/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Inquiry;
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
public class InquiryDao implements InInquiryDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Inquiry> getAllObject() {
        String hql = "FROM Inquiry p LEFT JOIN FETCH  p.user ORDER BY p.inqId";
        return (List<Inquiry>) hibernateTemplate.find(hql);
    }

    @Override
    public Inquiry getObjectById(int id) {
        return hibernateTemplate.get(Inquiry.class, id);
    }

    @Override
    public void addObject(Inquiry obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Inquiry obj) {
       
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Inquiry obj) {
 String hql = "FROM Inquiry as p WHERE p.inqTitle = ?";
        List<Inquiry> inquiry = (List<Inquiry>) hibernateTemplate.find(hql, obj);
        return inquiry.size() > 0 ? true : false;    }
}
