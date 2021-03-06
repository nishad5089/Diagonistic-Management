package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="testrequest")
public class TestRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pat_name")
    private String nameOfPatient;

    @Column(name="dob")
    private String dateOfBirth;

    @Column(name = "Mobile_no")
    private String mobileNO;


    @JoinTable(
            name="test_testrequest",
            joinColumns=@JoinColumn(name="testrequest_id"),
            inverseJoinColumns=@JoinColumn(name="test_id")
    )
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    private List<Test> tests;

    @Column(name= "amount")
    private double amount;

    @Column(name = "test_Request_date")
    private Date testRequestDate;

    @Column(name = "bill_no")
    private String bill_no;

    public TestRequest() {
    }

    public TestRequest(String nameOfPatient, String dateOfBirth, String mobileNO, List<Test> tests, double amount, Date testRequestDate, String bill_no) {
        this.nameOfPatient = nameOfPatient;
        this.dateOfBirth = dateOfBirth;
        this.mobileNO = mobileNO;
        this.tests = tests;
        this.amount = amount;
        this.testRequestDate = testRequestDate;
        this.bill_no = bill_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfPatient() {
        return nameOfPatient;
    }

    public void setNameOfPatient(String nameOfPatient) {
        this.nameOfPatient = nameOfPatient;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTestRequestDate(Date testRequestDate) {
        this.testRequestDate = testRequestDate;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTestRequestDate() {
        return testRequestDate;
    }

    public String getBill_no() {
        return bill_no;
    }
}