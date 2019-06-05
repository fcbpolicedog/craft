package com.policedog.craftadmin.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editAdmin(){
       return "";
    }
}
