/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.PaymentMethod;
import com.estate.real_estate.sevice.InPaymentMethodService;
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
@RequestMapping("/paymentMetho")
public class PaymentMethodController {
    @Autowired
    private InPaymentMethodService inPaymentMethodService;

    @RequestMapping("/home")
    public String home() {
        return "payment_method";
    }

    @RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.GET)
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable("id") Integer id) {
        PaymentMethod paymentMethod = inPaymentMethodService.getObjectById(id);
        return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentMethod", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethod() {
        List<PaymentMethod> list = inPaymentMethodService.getAllObject();
        return new ResponseEntity<List<PaymentMethod>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST)
    public ResponseEntity<Void> addPaymentMethod(@RequestBody PaymentMethod paymentMethod, UriComponentsBuilder builder) {
        
        inPaymentMethodService.addObject(paymentMethod);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/paymentMethod/{id}").buildAndExpand(paymentMethod.getPayMethodId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        inPaymentMethodService.updateObject(paymentMethod);
        return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable("id") Integer id) {
       inPaymentMethodService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
