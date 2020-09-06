package com.diagnosticbillmanagement.diagnosticbillmanagement.services;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import java.util.List;

public interface TestTypeService {
    List<TestType> findAll();

    TestType findById(int id);

    void save(TestType testType);

    void deleteById(int theId);

    boolean isTypeExist(String typeName);

}
