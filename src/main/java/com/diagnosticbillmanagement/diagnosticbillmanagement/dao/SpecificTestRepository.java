package com.diagnosticbillmanagement.diagnosticbillmanagement.dao;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.SpecificTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificTestRepository extends JpaRepository<SpecificTest, Integer> {
    public List<SpecificTest> findAllByOrderByNameAsc();
}
