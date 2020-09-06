package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
    @RequestMapping({"/admin/dashboard", "/admin"})
    public String dashboard() {
        return "admin/dashboard";
    }

    @RequestMapping("/admin/testsetup")
    public String testSetup() {
        return "admin/test_setup";
    }

    @RequestMapping("/admin/testrequest")
    public String testRequest() {
        return "admin/testRequest";
    }

}
