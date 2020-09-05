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
@RequestMapping("/tests")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestTypeService testTypeService;
    @GetMapping("/list")
    public String listTests(Model model) {

        List<Test> tests = testService.findAll();
        model.addAttribute("tests", tests);

        return "test/list-tests";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Test test = new Test();

        model.addAttribute("test", test);

        List<TestType> testTypeList = testTypeService.findAll();

        model.addAttribute("testtypes", testTypeList);

        return "test/test-form";
    }
    @PostMapping("/save")
    public String saveTest(@ModelAttribute("test") Test test) {


        testService.save(test);

        // use a redirect to prevent duplicate submissions
        return "redirect:/tests/list";

    }
}
