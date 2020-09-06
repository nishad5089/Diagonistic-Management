package com.diagnosticbillmanagement.diagnosticbillmanagement.service.imp;


import com.diagnosticbillmanagement.diagnosticbillmanagement.dao.TestTypeRepository;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import com.diagnosticbillmanagement.diagnosticbillmanagement.service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestTypeServiceImp implements TestTypeService {
    @Autowired
   private TestTypeRepository testTypeRepository;

    @Override
    public List<TestType> findAll() {
        return testTypeRepository.findAllByOrderByTypeNameAsc();
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
