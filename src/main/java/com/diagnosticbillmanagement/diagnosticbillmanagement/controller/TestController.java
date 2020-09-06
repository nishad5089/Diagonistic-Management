package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.service.test.TestService;
import com.diagnosticbillmanagement.diagnosticbillmanagement.service.testtype.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestTypeService testTypeService;

    @GetMapping("/testsetup")
    public String testSetup(Model model) {

        List<Test> tests = testService.findAll();
        model.addAttribute("tests", tests);

        List<TestType> testTypeList = testTypeService.findAll();
        model.addAttribute("testtypes", testTypeList);

        Test test = new Test();
        model.addAttribute("test", test);


        return "admin/test_setup";
    }

    @PostMapping("/testsetup/save")
    public String saveTest(@ModelAttribute("test") Test test) {


        testService.save(test);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/testsetup";

    }
}
