package com.diagnosticbillmanagement.diagnosticbillmanagement.repositories;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findAllByOrderByTestNameAsc();
}
