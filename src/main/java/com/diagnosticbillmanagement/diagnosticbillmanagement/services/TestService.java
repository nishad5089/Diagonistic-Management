package com.diagnosticbillmanagement.diagnosticbillmanagement.services;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import java.util.List;

public interface TestService {
    List<Test> findAll();

    Test findById(int id);

    void save(Test testType);

    void deleteById(int theId);
}
