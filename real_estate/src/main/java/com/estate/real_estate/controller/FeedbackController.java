/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.Feedback;
import com.estate.real_estate.sevice.InFeedbackService;
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
@RequestMapping("/feedbac")
public class FeedbackController {
    @Autowired
    private InFeedbackService inFeedbackService;

    @RequestMapping("/home")
    public String home() {
        return "feedback";
    }

    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.GET)
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") Integer id) {
        Feedback feedback = inFeedbackService.getObjectById(id);
        return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> list = inFeedbackService.getAllObject();
        return new ResponseEntity<List<Feedback>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ResponseEntity<Void> addFeedback(@RequestBody Feedback feedback, UriComponentsBuilder builder) {
        
        inFeedbackService.addObject(feedback);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/feedback/{id}").buildAndExpand(feedback.getFeedId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
        inFeedbackService.updateObject(feedback);
        return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
    }

    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFeedback(@PathVariable("id") Integer id) {
       inFeedbackService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
