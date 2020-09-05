package com.diagnosticbillmanagement.diagnosticbillmanagement.service.testtype;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.SpecificTestType;

import java.util.List;


public interface SpecificTestTypeService {
    public List<SpecificTestType> findAll();
    public SpecificTestType findById(int id);
    public void save(SpecificTestType testType);
    public void deleteById(int theId);
}
