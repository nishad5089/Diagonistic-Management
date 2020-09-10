package com.diagnosticbillmanagement.diagnosticbillmanagement.services.impl;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestRequest;
import com.diagnosticbillmanagement.diagnosticbillmanagement.exceptions.TypeNotFoundException;
import com.diagnosticbillmanagement.diagnosticbillmanagement.repositories.TestRequestRepository;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TestRequestServiceImp implements TestRequestService {

    @Autowired
    private TestRequestRepository testRequestRepository;
   // private static final Logger logger = LoggerFactory.getLogger(TestRequestServiceImp.class);

    @Override
    public List<TestRequest> findAll() {
        return null;
    }

    public TestRequest getTypeByTypeName(String bill_no) {
        if(bill_no == null){
            return null;
        }
        return this.findAll().stream()
                .filter(p -> Objects.equals(p.getBill_no().toLowerCase(), bill_no.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TestRequest findById(int id) {
        Optional<TestRequest> result = testRequestRepository.findById(id);
        TestRequest testRequest = null;
        if(result.isPresent()){
           // logger.info("---Type Found---");
            testRequest = result.get();
        }else {
            throw new TypeNotFoundException("Did not find Test");
        }
        return testRequest;

    }

    @Override
    public void save(TestRequest testType) {

    }

    @Override
    public void deleteById(int theId) {

    }

    @Override
    public boolean isBillNoExist(String bill_no) {
        return this.getTypeByTypeName(bill_no) instanceof TestRequest ? true : false;
    }
}
