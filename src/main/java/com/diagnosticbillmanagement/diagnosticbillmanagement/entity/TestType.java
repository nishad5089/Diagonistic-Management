package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name="test_type")
public class TestType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="test_name",unique = true)
    private String testName;

    public TestType() {
    }
    public TestType(String testName) {
        this.testName = testName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "TestType{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                '}';
    }
}
