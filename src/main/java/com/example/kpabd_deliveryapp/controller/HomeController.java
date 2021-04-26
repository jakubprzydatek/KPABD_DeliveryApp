package com.example.kpabd_deliveryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @RequestMapping("/redelivered")
    public String deliveredReport(ModelMap map)
    {
        map.put("hello", "Welcome to my site");
        return "delivered";
    }

    @RequestMapping("/repending")
    public String pendingReport(ModelMap map)
    {
        map.put("hello", "Welcome to my site");
        return "pending";
    }

    @RequestMapping("/reontheway")
    public String onTheWayReport(ModelMap map)
    {
        map.put("hello", "Welcome to my site");
        return "ontheway";
    }
}
