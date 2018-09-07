/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Faculty
 */
//@RestController
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        //        return "Welcome to RestTemplate Example.";
        return "index";
    }
    
    @RequestMapping("/index")
    public String index() {
        return "index";
        
    }
    
    @RequestMapping("/about")
    public String about() {
        return "about";
        
    }
    
    @RequestMapping("/management")
    public String management() {
        return "management";
        
    }
    
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
        
    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
        
    }
    @RequestMapping("/buyer")
    public String buyer() {
        return "buyer";
        
    }
    @RequestMapping("/seller")
    public String seller() {
        return "seller";
        
    }
    @RequestMapping("/visitor")
    public String visitor() {
        return "visitor";
        
    }

    
    
}
