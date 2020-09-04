package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="test_type")
public class TestType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="test_name")
    private String typeName;

    @OneToMany(mappedBy = "testType", cascade = CascadeType.ALL)
    private List<Test> test;

    public TestType() {
    }
    public TestType(String testName) {
        this.typeName = testName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return typeName;
    }

    public void setTestName(String testName) {
        this.typeName = testName;
    }

    @Override
    public String toString() {
        return "TestType{" +
                "id=" + id +
                ", testName='" + typeName + '\'' +
                '}';
    }
}
