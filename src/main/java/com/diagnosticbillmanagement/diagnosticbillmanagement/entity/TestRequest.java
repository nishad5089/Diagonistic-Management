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

    @Column
    private Date DOB;

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
    private List<SpecificTest> specificTests;

    public TestRequest() {
    }

    public TestRequest(int id, String nameOfPatient, Date DOB, String mobileNO, List<SpecificTest> specificTests) {
        this.id = id;
        this.nameOfPatient = nameOfPatient;
        this.DOB = DOB;
        this.mobileNO = mobileNO;
        this.specificTests = specificTests;
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public List<SpecificTest> getSpecificTests() {
        return specificTests;
    }

    public void setSpecificTests(List<SpecificTest> specificTests) {
        this.specificTests = specificTests;
    }
}
