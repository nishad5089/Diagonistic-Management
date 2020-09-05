package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="test")
public class SpecificTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "payment")
    private int payment;

    @ManyToOne
    @JoinColumn(name = "testtype_id")
    private SpecificTestType testType;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="test_testrequest",
            joinColumns=@JoinColumn(name="test_id"),
            inverseJoinColumns=@JoinColumn(name="testrequest_id")
    )
    private List<TestRequest> testRequests;

    public SpecificTest() {
    }

    public SpecificTest(int id, String name, int payment) {
        this.id = id;
        this.name = name;
        this.payment = payment;

    }

    public SpecificTestType getTestType() {
        return testType;
    }

    public void setTestType(SpecificTestType testType) {
        this.testType = testType;
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

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public List<TestRequest> getTestRequests() {
        return testRequests;
    }

    public void setTestRequests(List<TestRequest> testRequests) {
        this.testRequests = testRequests;
    }
}
