package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Test Name should not be empty")
    @Column(name = "test_name")
    private String testName;

    @NotNull(message = "Fee should not be empty")
//    @DecimalMax(value = "9999999999.999", message = "The decimal value can not be more than 9999999999.999")
    @DecimalMin(value = "1.0", inclusive = false, message = "Fee must be greater then zero")
    @Digits(integer = 6, fraction = 2, message = "{javax.validation.constraints.Digits.message}")
    @Column(name = "fee")
    private BigDecimal fee;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                       CascadeType.MERGE,
                       CascadeType.DETACH,
                       CascadeType.REFRESH})
    @JoinColumn(name = "testtype_id")
    private TestType testType;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "tests")
    private List<TestRequest> testRequests;

    public Test() {
    }

    public Test(String testName, BigDecimal fee) {
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<TestRequest> getTestRequests() {
        return testRequests;
    }

    public void setTestRequests(List<TestRequest> testRequests) {
        this.testRequests = testRequests;
    }
}