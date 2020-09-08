package com.diagnosticbillmanagement.diagnosticbillmanagement.services;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestRequest;

import java.util.List;

public interface TestRequestService {
    List<TestRequest> findAll();

    TestRequest findById(int id);

    void save(TestRequest testType);

    void deleteById(int theId);

    boolean isBillNoExist(String bill_no);
}
