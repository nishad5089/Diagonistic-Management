package com.diagnosticbillmanagement.diagnosticbillmanagement.dao;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    public List<Test> findAllByOrderByTestNameAsc();
}
