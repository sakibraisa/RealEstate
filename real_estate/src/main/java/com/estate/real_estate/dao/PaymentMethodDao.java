/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.PaymentMethod;
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
public class PaymentMethodDao implements InPaymentMethodDao{
    
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<PaymentMethod> getAllObject() {
        String hql = "FROM PaymentMethod as p ORDER BY p.payMethodId";
        return (List<PaymentMethod>) hibernateTemplate.find(hql);
    }

    @Override
    public PaymentMethod getObjectById(int id) {
        return hibernateTemplate.get(PaymentMethod.class, id);
    }

    @Override
    public void addObject(PaymentMethod obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(PaymentMethod obj) {
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(PaymentMethod obj) {
 String hql = "FROM PaymentMethod as p WHERE p.payMethod = ?";
        List<PaymentMethod> paymentMethod = (List<PaymentMethod>) hibernateTemplate.find(hql, obj);
        return paymentMethod.size() > 0 ? true : false;    }
}
