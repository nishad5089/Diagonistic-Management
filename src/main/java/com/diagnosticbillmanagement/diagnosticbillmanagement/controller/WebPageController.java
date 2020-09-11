package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {

//    @RequestMapping({"/", "/home", "/index"})
//    public String home() {
//        return "home";
//    }

    @RequestMapping({"/login"})
    public String login() {
        return "admin/login";
    }
    @RequestMapping({"/register"})
    public String register() {
        return "admin/register";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
