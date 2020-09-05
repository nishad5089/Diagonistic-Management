package com.diagnosticbillmanagement.diagnosticbillmanagement.service.test;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.SpecificTest;

import java.util.List;

public interface SpecificTestService {
    public List<SpecificTest> findAll();
    public SpecificTest findById(int id);
    public void save(SpecificTest testType);
    public void deleteById(int theId);
}
