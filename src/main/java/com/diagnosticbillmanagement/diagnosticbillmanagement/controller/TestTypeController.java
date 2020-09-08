package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestTypeController {
    private TestTypeService testTypeService;
    private static Logger logger = LoggerFactory.getLogger(TestTypeController.class);

    @Autowired
    public TestTypeController(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @ModelAttribute
    public void init(Model model) {
        logger.info("---Page Refreshed---");
        List<TestType> testTypes = testTypeService.findAll();
        model.addAttribute("testtypelist", testTypes);
    }

    @GetMapping("/testtypesetup")
    public String testType(Model model) {
        logger.info("---Test Type Form Initialized---");
        TestType testType = new TestType();
        model.addAttribute("testtype", testType);
        return "admin/test_type_setup";
    }

    @PostMapping("/testtypesetup")
    public String saveTestType(@Valid @ModelAttribute("testtype") TestType testType, BindingResult errors) {
        if (errors.hasErrors()) {
            logger.error("Validation Errors : {}", errors.getAllErrors());
            return "admin/test_type_setup";
        }
        if (testTypeService.isTypeExist(testType.getTypeName())) {
            errors.addError(new FieldError("testtype", "typeName", "Type Name Already Exist"));
            return "admin/test_type_setup";
        }
        testTypeService.save(testType);
        logger.info("Successfully Saved Test Type");
        return "redirect:/admin/testtypesetup";
    }
}
