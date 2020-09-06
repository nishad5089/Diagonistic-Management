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

    @Column(name = "name")
    private String nameOfPatient;

    @Column(name="DOB")
    private Date dateOfBirth;

    @Column(name = "Mobile_no")
    private String mobileNO;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="test_testrequest",
            joinColumns=@JoinColumn(name="testrequest_id"),
            inverseJoinColumns=@JoinColumn(name="test_id")
    )
    private List<Test> tests;

    public TestRequest() {
    }

    public TestRequest(int id, String nameOfPatient, Date dateOfBirth, String mobileNO, List<Test> tests) {
        this.id = id;
        this.nameOfPatient = nameOfPatient;
        this.dateOfBirth = dateOfBirth;
        this.mobileNO = mobileNO;
        this.tests = tests;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
}
