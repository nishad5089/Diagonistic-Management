package com.diagnosticbillmanagement.diagnosticbillmanagement.services.impl;


import com.diagnosticbillmanagement.diagnosticbillmanagement.repositories.TestTypeRepository;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.services.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TestTypeServiceImp implements TestTypeService {
    @Autowired
   private TestTypeRepository testTypeRepository;

    @Override
    public List<TestType> findAll() {
        return testTypeRepository.findAllByOrderByTypeNameAsc();
    }
    public TestType getCountryById(String typeName) {
        return this.findAll().stream()
                .filter(p -> Objects.equals(p.getTypeName().toLowerCase(), typeName.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isTypeExist(String typeName) {
        return this.getCountryById(typeName) instanceof TestType ? true : false;
    }
    @Override
    public TestType findById(int id) {
        Optional<TestType> result = testTypeRepository.findById(id);
        TestType testType = null;
        if(result.isPresent()){
            testType = result.get();
        }else {
            throw new RuntimeException("Did not find Test");
        }
        return testType;
    }

    @Override
    public void save(TestType testType) {
        testTypeRepository.save(testType);
    }

    @Override
    public void deleteById(int theId) {

    }
}
