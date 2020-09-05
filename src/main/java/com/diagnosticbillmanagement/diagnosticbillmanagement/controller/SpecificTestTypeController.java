package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;


import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.SpecificTestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.service.testtype.SpecificTestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/testtypes")
public class SpecificTestTypeController {
    private SpecificTestTypeService testTypeService;
    @Autowired
    public SpecificTestTypeController(SpecificTestTypeService testTypeService) {
        this.testTypeService = testTypeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<SpecificTestType> testTypes = testTypeService.findAll();

        // add to the spring model
        model.addAttribute("testtypes", testTypes);

        //return "employees/list-employees";
        return "/list-testtypes";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        SpecificTestType testType = new SpecificTestType();

        theModel.addAttribute("testtype", testType);

        //return "employees/employee-form";
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
//       // return "employees/employee-form";
//        return "";
//    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("testtype") SpecificTestType testType) {

        // save the employee
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
//        // redirect to /employees/list
//       // return "redirect:/employees/list";
//        return "";
//
//    }

}
