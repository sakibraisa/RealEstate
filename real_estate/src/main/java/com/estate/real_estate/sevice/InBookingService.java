/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.domain.Booking;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InBookingService {
    List<Booking> getAllObject();

    Booking getObjectById(int id);

    void addObject(Booking obj);

    void updateObject(Booking obj);

    void deleteObject(int id);
}
