package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestRequest;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestRequestService;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class TestRequestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestRequestService testRequestService;
    private Set<String> tests = null;
    List<Test> testlist = null;
    private Map<String, Set<String>> testrequestmap = new HashMap<>();
    private static Logger logger = LoggerFactory.getLogger(TestRequestController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ModelAttribute
    public void init(Model model) {
        logger.info("---Page Refreshed---");
        List<Test> tests = testService.findAll();
        model.addAttribute("testlist", tests);
    }

    @GetMapping("/testrequest")
    public String testRequest(Model model) {
        TestRequest testRequest = new TestRequest();
        model.addAttribute("testRequest", testRequest);
        return "admin/test_request";
    }

    @RequestMapping(value = "/testrequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    boolean saveTestRequest(@RequestBody TestRequest testRequest) {
        testRequest.setTests(testlist);
        for (Test test : testlist) {
            test.getTestRequests().add(testRequest);
        }
        testRequestService.save(testRequest);
        testlist = null;


        return true;
    }

    @RequestMapping(value = "/gettest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Test getTest(@RequestParam("id") int id) {
        Test test = testService.findById(id);
        test.setTestType(null);
        TestType type = new TestType("Scalve");
        test.setTestType(type);
        if (testlist == null) {
            testlist = new ArrayList<>();
        }
        testlist.add(test);
//        if(!testrequestmap.containsKey(testRequest.getMobileNO())){
//            tests = new TreeSet<>();
//            testrequestmap = new HashMap<>();
//            if(testlist == null){
//                testlist = new ArrayList<>();
//            }
//            tests.add(test.getTestName());
//            testlist.add(test);
//            testrequestmap.put(testRequest.getMobileNO(),tests);
//        }else {
//            tests = testrequestmap.get(testRequest.getMobileNO());
//            if(!tests.contains(test.getTestName())) {
//                tests.add(test.getTestName());
//                testlist.add(test);
//                testrequestmap.put(testRequest.getMobileNO(),tests);
//            }else {
//
//            }
//        }
        return test;
    }

    @RequestMapping(value = "/testfee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Test getFeebyTestId(@RequestBody int id) {
        Test test = testService.findById(id);
        test.setTestType(null);
        return test;
    }
}
