/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import com.estate.real_estate.domain.Area;
import com.estate.real_estate.sevice.InAreaService;
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
@RequestMapping("/are")
public class AreaController {
    @Autowired
    private InAreaService inAreaService;

    @RequestMapping("/home")
    public String home() {
        return "area";
    }

    @RequestMapping(value = "/area/{id}", method = RequestMethod.GET)
    public ResponseEntity<Area> getAreaById(@PathVariable("id") Integer id) {
        Area area = inAreaService.getObjectById(id);
        return new ResponseEntity<Area>(area, HttpStatus.OK);
    }

    @RequestMapping(value = "/area", method = RequestMethod.GET)
    public ResponseEntity<List<Area>> getAllArea() {
        List<Area> list = inAreaService.getAllObject();
        return new ResponseEntity<List<Area>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/area", method = RequestMethod.POST)
    public ResponseEntity<Void> addArea(@RequestBody Area area, UriComponentsBuilder builder) {
        
        inAreaService.addObject(area);
        boolean flag=true;
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/area/{id}").buildAndExpand(area.getAreaId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/area/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Area> updateArea(@RequestBody Area area) {
        inAreaService.updateObject(area);
        return new ResponseEntity<Area>(area, HttpStatus.OK);
    }

    @RequestMapping(value = "/area/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteArea(@PathVariable("id") Integer id) {
       inAreaService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
