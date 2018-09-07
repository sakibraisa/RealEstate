/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.City;
import com.estate.real_estate.sevice.InCityService;
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


@Controller
@RequestMapping("/cit")
public class CityController {
    @Autowired
    private InCityService cityService;

    @RequestMapping("/home")
    public String home() {
        return "city";
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> getCityById(@PathVariable("id") Integer id) {
        City city = cityService.getObjectById(id);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getAllCity() {
        List<City> list = cityService.getAllObject();
        return new ResponseEntity<List<City>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public ResponseEntity<Void> addCity(@RequestBody City city, UriComponentsBuilder builder) {
        boolean flag = cityService.addObject(city);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/city/{id}").buildAndExpand(city.getCityId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.PUT)
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        cityService.updateObject(city);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Integer id) {
        cityService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
