/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InInquiryDao;
import com.estate.real_estate.domain.Inquiry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class InquiryService implements InInquiryService{
    @Autowired
    private InInquiryDao InInquiryDao;

    @Override
    public List<Inquiry> getAllObject() {
        return InInquiryDao.getAllObject();
    }

    @Override
    public Inquiry getObjectById(int id) {
        Inquiry obj= InInquiryDao.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(Inquiry obj) {
        InInquiryDao.addObject(obj);
        return false;
    }

    @Override
    public void updateObject(Inquiry obj) {
        InInquiryDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InInquiryDao.deleteObject(id);
    }
}
