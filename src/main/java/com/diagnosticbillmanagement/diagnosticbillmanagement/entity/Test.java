package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "test_name", unique = true)
    private String testName;

    @Column(name = "fee")
    private double fee;

    @ManyToOne(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "testtype_id")
    private TestType testType;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="test_testrequest",
            joinColumns=@JoinColumn(name="test_id"),
            inverseJoinColumns=@JoinColumn(name="testrequest_id")
    )
    private List<TestRequest> testRequests;

    public Test() {
    }

    public Test(int id, String testName, double fee) {
        this.id = id;
        this.testName = testName;
        this.fee = fee;

    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
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

    public List<TestRequest> getTestRequests() {
        return testRequests;
    }

    public void setTestRequests(List<TestRequest> testRequests) {
        this.testRequests = testRequests;
    }
}