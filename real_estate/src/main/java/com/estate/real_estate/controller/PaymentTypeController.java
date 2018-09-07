/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.PaymentType;
import com.estate.real_estate.sevice.InPaymentTypeService;
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
@RequestMapping("/paymentTyp")
public class PaymentTypeController {
    @Autowired
    private InPaymentTypeService inPaymentTypeService;

    @RequestMapping("/home")
    public String home() {
        return "payment_type";
    }

    @RequestMapping(value = "/paymentType/{id}", method = RequestMethod.GET)
    public ResponseEntity<PaymentType> getPaymentTypeById(@PathVariable("id") Integer id) {
        PaymentType paymentType = inPaymentTypeService.getObjectById(id);
        return new ResponseEntity<PaymentType>(paymentType, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentType", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentType>> getAllPaymentType() {
        List<PaymentType> list = inPaymentTypeService.getAllObject();
        return new ResponseEntity<List<PaymentType>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentType", method = RequestMethod.POST)
    public ResponseEntity<Void> addPaymentType(@RequestBody PaymentType paymentType, UriComponentsBuilder builder) {
        
        inPaymentTypeService.addObject(paymentType);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/paymentType/{id}").buildAndExpand(paymentType.getPayTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/paymentType/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PaymentType> updatePaymentType(@RequestBody PaymentType paymentType) {
        inPaymentTypeService.updateObject(paymentType);
        return new ResponseEntity<PaymentType>(paymentType, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePaymentType(@PathVariable("id") Integer id) {
       inPaymentTypeService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
