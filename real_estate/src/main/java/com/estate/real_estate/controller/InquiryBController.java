/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.Inquiry;
import com.estate.real_estate.sevice.InInquiryService;
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
@RequestMapping("/inquirb")
public class InquiryBController {
    @Autowired
    private InInquiryService inInquiryService;

    @RequestMapping("/home")
    public String home() {
        return "inquiryb";
    }

    @RequestMapping(value = "/inquiry/{id}", method = RequestMethod.GET)
    public ResponseEntity<Inquiry> getInquiryById(@PathVariable("id") Integer id) {
        Inquiry inquiry = inInquiryService.getObjectById(id);
        return new ResponseEntity<Inquiry>(inquiry, HttpStatus.OK);
    }

    @RequestMapping(value = "/inquiry", method = RequestMethod.GET)
    public ResponseEntity<List<Inquiry>> getAllInquiry() {
        List<Inquiry> list = inInquiryService.getAllObject();
        return new ResponseEntity<List<Inquiry>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/inquiry", method = RequestMethod.POST)
    public ResponseEntity<Void> addInquiry(@RequestBody Inquiry inquiry, UriComponentsBuilder builder) {
        
        inInquiryService.addObject(inquiry);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/inquiry/{id}").buildAndExpand(inquiry.getInqId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/inquiry/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Inquiry> updateInquiry(@RequestBody Inquiry inquiry) {
        inInquiryService.updateObject(inquiry);
        return new ResponseEntity<Inquiry>(inquiry, HttpStatus.OK);
    }

    @RequestMapping(value = "/inquiry/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteInquiry(@PathVariable("id") Integer id) {
       inInquiryService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
