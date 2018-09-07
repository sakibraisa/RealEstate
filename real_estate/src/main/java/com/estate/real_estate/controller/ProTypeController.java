/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.ProType;
import com.estate.real_estate.sevice.InProTypeService;
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
@RequestMapping("/proTyp")
public class ProTypeController {
    @Autowired
    private InProTypeService inProTypeService;

    @RequestMapping("/home")
    public String home() {
        return "pro_type";
    }

    @RequestMapping(value = "/proType/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProType> getProTypeById(@PathVariable("id") Integer id) {
        ProType proType = inProTypeService.getObjectById(id);
        return new ResponseEntity<ProType>(proType, HttpStatus.OK);
    }

    @RequestMapping(value = "/proType", method = RequestMethod.GET)
    public ResponseEntity<List<ProType>> getAllProType() {
        List<ProType> list = inProTypeService.getAllObject();
        return new ResponseEntity<List<ProType>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/proType", method = RequestMethod.POST)
    public ResponseEntity<Void> addProType(@RequestBody ProType proType, UriComponentsBuilder builder) {
        
        inProTypeService.addObject(proType);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/proType/{id}").buildAndExpand(proType.getProTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/proType/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProType> updateProType(@RequestBody ProType proType) {
        inProTypeService.updateObject(proType);
        return new ResponseEntity<ProType>(proType, HttpStatus.OK);
    }

    @RequestMapping(value = "/proType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProType(@PathVariable("id") Integer id) {
       inProTypeService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
