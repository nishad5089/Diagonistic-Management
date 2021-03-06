package com.diagnosticbillmanagement.diagnosticbillmanagement.repositories;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.TestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestTypeRepository extends JpaRepository<TestType, Integer> {
    List<TestType> findAllByOrderByTypeNameAsc();
}
