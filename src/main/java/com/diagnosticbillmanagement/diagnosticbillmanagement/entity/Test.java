package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "test_name")
    private String testName;
    private double fee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private TestType testType;

    public Test() {
    }
    public Test(String testName, double fee, TestType testType) {
        this.testName = testName;
        this.fee = fee;
        this.testType = testType;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", TestName='" + testName + '\'' +
                ", fee='" + fee + '\'' +
                ", testType=" + testType +
                '}';
    }
}
