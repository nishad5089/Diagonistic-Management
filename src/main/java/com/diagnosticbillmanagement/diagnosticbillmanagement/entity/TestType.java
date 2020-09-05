package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="testtype")
public class TestType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name",unique=true)
    private String name;

    @OneToMany(mappedBy = "testType", cascade = CascadeType.ALL)
    private List<Test> tests;

    public TestType() {
    }

    public TestType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public TestType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "TestType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    public void add(Test test){
//
//        if(tests == null){
//            tests = new ArrayList<>();
//        }
//        tests.add(test);
//        test.setTestType(this);
//    }
}
