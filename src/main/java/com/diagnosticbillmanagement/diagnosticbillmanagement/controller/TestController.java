package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;


import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestService;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestTypeService testTypeService;
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @ModelAttribute
    public void init(Model model) {
        logger.info("---Page Refreshed---");
        List<Test> tests = testService.findAll();
        model.addAttribute("tests", tests);
        List<TestType> testTypeList = testTypeService.findAll();
        model.addAttribute("testtypes", testTypeList);
    }

    @GetMapping("/testsetup")
    public String testSetup(Model model) {
        Test test = new Test();
        model.addAttribute("test", test);
        return "admin/test_setup";
    }

    @PostMapping("/testsetup")
    public String saveTest(@Valid @ModelAttribute("test") Test test, BindingResult errors) {
        if (errors.hasErrors()) {
            logger.error("Validation Errors : {}", errors.getAllErrors());
            return "admin/test_setup";
        }
        testService.save(test);
        return "redirect:/admin/testsetup";
    }
}