/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.Property;
import com.estate.real_estate.sevice.InPropertyService;
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
@RequestMapping("/propertvie")
public class PropertyViewController {
    @Autowired
    private InPropertyService inPropertyService;

    @RequestMapping("/home")
    public String home() {
        return "viewproperty";
    }

    @RequestMapping(value = "/property/{id}", method = RequestMethod.GET)
    public ResponseEntity<Property> getPropertyById(@PathVariable("id") Integer id) {
        Property property = inPropertyService.getObjectById(id);
        return new ResponseEntity<Property>(property, HttpStatus.OK);
    }

    @RequestMapping(value = "/property", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> getAllArea() {
        List<Property> list = inPropertyService.getAllObject();
        return new ResponseEntity<List<Property>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/property", method = RequestMethod.POST)
    public ResponseEntity<Void> addProperty(@RequestBody Property property, UriComponentsBuilder builder) {
        
        inPropertyService.addObject(property);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/property/{id}").buildAndExpand(property.getProId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/property/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Property> updateProperty(@RequestBody Property property) {
        inPropertyService.updateObject(property);
        return new ResponseEntity<Property>(property, HttpStatus.OK);
    }

    @RequestMapping(value = "/property/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Integer id) {
       inPropertyService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
