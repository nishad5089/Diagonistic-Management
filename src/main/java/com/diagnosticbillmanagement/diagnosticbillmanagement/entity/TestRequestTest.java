package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name ="test_testrequest")
public class TestRequestTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "testRequest_id")
    TestRequest testRequest;

    @ManyToOne
    @JoinColumn(name = "test_id")
    Test test;

    LocalDate creationDate;

    public TestRequestTest() {
        this.creationDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestRequest getTestRequest() {
        return testRequest;
    }

    public void setTestRequest(TestRequest testRequest) {
        this.testRequest = testRequest;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
