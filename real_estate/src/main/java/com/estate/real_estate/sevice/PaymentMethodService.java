/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InPaymentMethodDao;
import com.estate.real_estate.domain.PaymentMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class PaymentMethodService implements InPaymentMethodService{
    @Autowired
    private InPaymentMethodDao InPaymentMethodDao;

    @Override
    public List<PaymentMethod> getAllObject() {
        return InPaymentMethodDao.getAllObject();
    }

    @Override
    public PaymentMethod getObjectById(int id) {
        PaymentMethod obj= InPaymentMethodDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(PaymentMethod obj) {
        InPaymentMethodDao.addObject(obj);
    }

    @Override
    public void updateObject(PaymentMethod obj) {
        InPaymentMethodDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InPaymentMethodDao.deleteObject(id);
    }
}
