package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;


import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestTypeController {
    private TestTypeService testTypeService;
    @Autowired
    public TestTypeController(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;
    }

    @GetMapping("/testtypesetup")
    public String testType(Model model) {

        List<TestType> testTypes = testTypeService.findAll();
        model.addAttribute("testtypelist", testTypes);

        TestType testType = new TestType();
        model.addAttribute("testtype", testType);

        return "admin/test_type_setup";
    }

    @PostMapping("/testtypesetup/save")
    public String saveTestType(@ModelAttribute("testtype") TestType testType) {

        testTypeService.save(testType);

        return "redirect:/admin/testtypesetup";

    }


}
© 2020 GitHub, Inc.