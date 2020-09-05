package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;


import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.service.testtype.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/testtypes")
public class TestTypeController {
    private TestTypeService testTypeService;
    @Autowired
    public TestTypeController(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;
    }

    @GetMapping("/list")
    public String listTestTypes(Model model) {

        List<TestType> testTypes = testTypeService.findAll();

        // add to the spring model
        model.addAttribute("testtypes", testTypes);

        return "/list-testtypes";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        TestType testType = new TestType();

        theModel.addAttribute("testtype", testType);

        return "testtype-form";
    }

    //  @GetMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("testtypeId") int id,
//                                    Model theModel) {
//
//        // get the employee from the service
//        TestType testType = testTypeService.findById(id);
//
//        // set employee as a model attribute to pre-populate the form
//        theModel.addAttribute("testtype", testType);
//
//        // send over to our form
//
//        return "";
//    }
    @PostMapping("/save")
    public String saveTestType(@ModelAttribute("testtype") TestType testType) {

        testTypeService.save(testType);

        // use a redirect to prevent duplicate submissions
        return "redirect:/testtypes/list";

    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam("testtypeId") int id) {
//
//        // delete the employee
//        testTypeService.deleteById(id);
//
//       // return "redirect:/tests/list";
//        return "";
//
//    }

}
