/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.PaymentType;
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
public class PaymentTypeDao implements InPaymentTypeDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<PaymentType> getAllObject() {
        String hql = "FROM PaymentType as p ORDER BY p.payTypeId";
        return (List<PaymentType>) hibernateTemplate.find(hql);
    }

    @Override
    public PaymentType getObjectById(int id) {
        return hibernateTemplate.get(PaymentType.class, id);
    }

    @Override
    public void addObject(PaymentType obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(PaymentType obj) {
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(PaymentType obj) {
 String hql = "FROM PaymentType as p WHERE p.payType = ?";
        List<PaymentType> PaymentType = (List<PaymentType>) hibernateTemplate.find(hql, obj);
        return PaymentType.size() > 0 ? true : false;    }
}
