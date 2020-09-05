package com.diagnosticbillmanagement.diagnosticbillmanagement.service.test;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;

import java.util.List;

public interface TestService {
    public List<Test> findAll();
    public Test findById(int id);
    public void save(Test testType);
    public void deleteById(int theId);
}
