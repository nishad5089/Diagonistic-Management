package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="testtype")
public class TestType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "Type Name should not be empty")
    @Column(name="type_name",unique=true)
    private String typeName;

    @OneToMany(mappedBy = "testType", cascade = CascadeType.ALL)
    private List<Test> tests;

    public TestType() {
    }

    public TestType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public TestType(String typeName) {
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return "TestType{" +
                "id=" + id +
                ", name='" + typeName + '\'' +
                '}';
    }

}