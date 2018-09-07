/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.UserType;
import com.estate.real_estate.sevice.InUserTypeService;
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
@RequestMapping("/userTyp")
public class UserTypeController {
    @Autowired
    private InUserTypeService inUserTypeService;

    @RequestMapping("/home")
    public String home() {
        return "user_type";
    }

    @RequestMapping(value = "/userType/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserType> getUserTypeById(@PathVariable("id") Integer id) {
        UserType userType = inUserTypeService.getObjectById(id);
        return new ResponseEntity<UserType>(userType, HttpStatus.OK);
    }

    @RequestMapping(value = "/userType", method = RequestMethod.GET)
    public ResponseEntity<List<UserType>> getAllUserType() {
        List<UserType> list = inUserTypeService.getAllObject();
        return new ResponseEntity<List<UserType>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/userType", method = RequestMethod.POST)
    public ResponseEntity<Void> addUserType(@RequestBody UserType userType, UriComponentsBuilder builder) {
        
        inUserTypeService.addObject(userType);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/userType/{id}").buildAndExpand(userType.getUserTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/userType/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserType> updateUserType(@RequestBody UserType userType) {
        inUserTypeService.updateObject(userType);
        return new ResponseEntity<UserType>(userType, HttpStatus.OK);
    }

    @RequestMapping(value = "/userType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserType(@PathVariable("id") Integer id) {
       inUserTypeService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
