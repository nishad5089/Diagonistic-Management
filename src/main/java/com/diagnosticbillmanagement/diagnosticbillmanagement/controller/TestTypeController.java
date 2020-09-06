package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;
import com.diagnosticbillmanagement.diagnosticbillmanagement.dto.TestTypeDto;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestTypeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestTypeController {
    private TestTypeService testTypeService;
    Logger logger = LoggerFactory.getLogger(TestTypeController.class);

    @Autowired
    public TestTypeController(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;
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
        TestTypeDto testTypeDto = new TestTypeDto();
        model.addAttribute("testtype", testTypeDto);
        return "admin/test_type_setup";
    }

    @PostMapping("/testtypesetup")
    public String saveTestType(@Valid @ModelAttribute("testtype") TestTypeDto testTypeDto, BindingResult errors) {
        if (testTypeService.isTypeExist(testTypeDto.getTypeName())) {
            errors.addError(new FieldError("testtype", "typeName", "Type Name Already Exist"));
        }
        if (errors.hasErrors()) {
            logger.error("Validation Errors : {}", errors.getAllErrors());
            return "admin/test_type_setup";
        }
        ModelMapper modelMapper = new ModelMapper();
        TestType testType = modelMapper.map(testTypeDto, TestType.class);
        testTypeService.save(testType);
        logger.info("Successfully Saved Test Type");
        return "redirect:/admin/testtypesetup";
    }
}
