/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InBookingDao;
import com.estate.real_estate.domain.Booking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author C6
 */
@Service
public class BookingService implements InBookingService{
    
     @Autowired
    private InBookingDao InBookingDao;
    
    @Override
    public List<Booking> getAllObject() {
        return InBookingDao.getAllObject();
    }

    @Override
    public Booking getObjectById(int id) {
       Booking obj= InBookingDao.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(Booking obj) {
        InBookingDao.addObject(obj);
    }

    @Override
    public void updateObject(Booking obj) {
        InBookingDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InBookingDao.deleteObject(id);
    }
}
