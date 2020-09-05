package com.diagnosticbillmanagement.diagnosticbillmanagement.service.test;

import com.diagnosticbillmanagement.diagnosticbillmanagement.dao.SpecificTestRepository;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.SpecificTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecificTestServiceImp implements SpecificTestService {
    @Autowired
    private SpecificTestRepository testRepository;

    @Override
    public List<SpecificTest> findAll() {
        return testRepository.findAllByOrderByNameAsc();
    }

    @Override
    public SpecificTest findById(int id) {
        Optional<SpecificTest> result = testRepository.findById(id);
        SpecificTest test = null;
        if(result.isPresent()){
            test = result.get();
        }else {
            throw new RuntimeException("Did not find Test");
        }
        return test;
    }

    @Override
    public void save(SpecificTest testType) {
        testRepository.save(testType);
    }

    @Override
    public void deleteById(int theId) {

    }
}
