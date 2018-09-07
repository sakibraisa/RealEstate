/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InPaymentTypeDao;
import com.estate.real_estate.domain.PaymentType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class PaymentTypeService implements InPaymentTypeService{
    @Autowired
    private InPaymentTypeDao InPaymentTypeDao;

    @Override
    public List<PaymentType> getAllObject() {
        return InPaymentTypeDao.getAllObject();
    }

    @Override
    public PaymentType getObjectById(int id) {
        PaymentType obj= InPaymentTypeDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(PaymentType obj) {
        InPaymentTypeDao.addObject(obj);
    }

    @Override
    public void updateObject(PaymentType obj) {
        InPaymentTypeDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InPaymentTypeDao.deleteObject(id);
    }
}
