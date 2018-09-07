/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.Booking;
import com.estate.real_estate.sevice.InBookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author C6
 */
@Controller
@RequestMapping("/bookinb")
public class BookingBController {
    
    @Autowired
    private InBookingService inBookingService;

    @RequestMapping("/home")
    public String home() {
        return "booking";
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET)
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Integer id) {
        Booking booking = inBookingService.getObjectById(id);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> getAllArea() {
        List<Booking> list = inBookingService.getAllObject();
        return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking, UriComponentsBuilder builder) {
        
        inBookingService.addObject(booking);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/booking/{id}").buildAndExpand(booking.getBookId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        inBookingService.updateObject(booking);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Integer id) {
       inBookingService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
