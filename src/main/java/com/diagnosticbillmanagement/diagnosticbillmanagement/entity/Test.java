package com.diagnosticbillmanagement.diagnosticbillmanagement.entity;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Test Name should not be empty")
    @Column(name = "test_name")
    private String testName;

    @NotNull(message = "Fee should not be empty")
//    @DecimalMax(value = "9999999999.999", message = "The decimal value can not be more than 9999999999.999")
    @DecimalMin(value = "1.0", inclusive = false,message = "Fee must be greater then zero")
    @Digits(integer = 6, fraction = 2, message = "{javax.validation.constraints.Digits.message}")
    @Column(name = "fee")
    private BigDecimal fee;

    @ManyToOne(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "testtype_id")
    private TestType testType;

//    @ManyToMany(fetch=FetchType.LAZY,
//            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(
//            name="test_testrequest",
//            joinColumns=@JoinColumn(name="test_id"),
//            inverseJoinColumns=@JoinColumn(name="testrequest_id")
//    )
//    private List<TestRequest> testRequests;
    @OneToMany(mappedBy = "test")
    private Set<TestRequestTest> testRequestTests;
    public Test() {
    }

    public Test(int id, String testName, BigDecimal fee) {
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
//
//    public List<TestRequest> getTestRequests() {
//        return testRequests;
//    }
//
//    public void setTestRequests(List<TestRequest> testRequests) {
//        this.testRequests = testRequests;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return id == test.id &&
                Objects.equals(testName, test.testName) &&
                Objects.equals(fee, test.fee) &&
                Objects.equals(testType, test.testType) &&
                Objects.equals(testRequestTests, test.testRequestTests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testName, fee, testType, testRequestTests);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                ", fee=" + fee +
                '}';
    }
}