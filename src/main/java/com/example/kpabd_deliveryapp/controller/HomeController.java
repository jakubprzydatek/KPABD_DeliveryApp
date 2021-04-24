package com.example.kpabd_deliveryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(ModelMap map)
    {
        map.put("hello", "Welcome to my site");
        return "home";
    }
}
