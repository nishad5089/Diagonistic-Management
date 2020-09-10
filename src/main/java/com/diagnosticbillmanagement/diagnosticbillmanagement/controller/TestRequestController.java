package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestRequestTest;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestRequestService;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private Map<String,Set<String>> testrequestmap= new HashMap<>();
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

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
        TestRequestTest testRequest = new TestRequestTest();
        model.addAttribute("testRequest", testRequest);
        return "admin/test_request";
    }
    @RequestMapping(value = "/testrequest", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String  saveTestRequest(@RequestBody TestRequestTest testRequestTest, BindingResult errors) {
        Test test =  testService.findById(testRequestTest.getTest().getId());

        if(!testrequestmap.containsKey(testRequestTest.getTestRequest().getMobileNO())){
            tests = new TreeSet<>();
            testrequestmap = new HashMap<>();
            if(testlist == null){
                testlist = new ArrayList<>();
            }
            tests.add(test.getTestName());
            testlist.add(test);
            testrequestmap.put(testRequestTest.getTestRequest().getMobileNO(),tests);
        }else {
            tests = testrequestmap.get(testRequestTest.getTestRequest().getMobileNO());
            if(!tests.contains(test.getTestName())) {
                tests.add(test.getTestName());
                testlist.add(test);
                testrequestmap.put(testRequestTest.getTestRequest().getMobileNO(),tests);
            }else {

            }
        }
        Gson gson = new Gson();
String jsonStr = gson.toJson(test);
//        if(errors.hasErrors()) {
//            return "admin/test_request";
//        }
//        return "redirect:/admin/testrequest";
//        JSONArray s = new JSONArray(testlist);
//        String jsonStr =s.toString();
//        JSONObject jo = new JSONObject();
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(test);
//        ObjectMapper mapper = new ObjectMapper();
//        //Converting the Object to JSONString
//        JSONObject obj = new JSONObject(test);

//        ObjectMapper mapper = new ObjectMapper();
//        //Converting the Object to JSONString
//        String jsonString = mapper.writeValueAsString(test);
        return jsonStr;
    }

    @RequestMapping(value = "/testfee", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    BigDecimal getFeebyTestId(@Valid @RequestBody int id, Errors errors) {
        Test test =  testService.findById(id);
        return test.getFee();
    }
}
