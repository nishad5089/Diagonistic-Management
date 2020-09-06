package com.diagnosticbillmanagement.diagnosticbillmanagement.services.impl;

import com.diagnosticbillmanagement.diagnosticbillmanagement.repositories.TestRepository;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImp implements TestService {
    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Test> findAll() {
        return testRepository.findAllByOrderByTestNameAsc();
    }

    @Override
    public Test findById(int id) {
        Optional<Test> result = testRepository.findById(id);
        Test test = null;
        if(result.isPresent()){
            test = result.get();
        }else {
            throw new RuntimeException("Did not find Test");
        }
        return test;
    }

    @Override
    public void save(Test testType) {
        testRepository.save(testType);
    }

    @Override
    public void deleteById(int theId) {

    }
}
