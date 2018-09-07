/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Booking;
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
public class BookingDao implements InBookingDao{
    
     @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Booking> getAllObject() {
        String hql = "FROM Booking p LEFT JOIN FETCH  p.paymentMethod LEFT JOIN FETCH  p.paymentType LEFT JOIN FETCH  p.user LEFT JOIN FETCH  p.proType ORDER BY p.bookId";
        return (List<Booking>) hibernateTemplate.find(hql);
    }

    @Override
    public Booking getObjectById(int id) {
        return hibernateTemplate.get(Booking.class, id);
    }

    @Override
    public void addObject(Booking obj) {
        if(obj.getAmountPaid()==obj.getDueAmount()){
            obj.setPaymentStatus("Paid");
        }else{
            obj.setPaymentStatus("Unpaid");
        }
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Booking obj) {
        if(obj.getAmountPaid()==obj.getDueAmount()){
            obj.setPaymentStatus("Paid");
        }else{
            obj.setPaymentStatus("Unpaid");
        }
        
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Booking obj) {
 String hql = "FROM Booking as p WHERE p.dueDate = ?";
        List<Booking> booking = (List<Booking>) hibernateTemplate.find(hql, obj);
        return booking.size() > 0 ? true : false;    }
}
