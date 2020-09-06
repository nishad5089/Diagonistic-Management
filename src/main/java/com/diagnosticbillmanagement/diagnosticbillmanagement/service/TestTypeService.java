package com.diagnosticbillmanagement.diagnosticbillmanagement.service;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;

import java.util.List;


public interface TestTypeService {
    public List<TestType> findAll();
    public TestType findById(int id);
    public void save(TestType testType);
    public void deleteById(int theId);
}
