package com.diagnosticbillmanagement.diagnosticbillmanagement.dto;

import javax.validation.constraints.NotBlank;

public class TestTypeDto {
    @NotBlank(message = "Type Name should not be empty")
    private String typeName;

    public TestTypeDto() {
    }

    public TestTypeDto(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TestTypeDto{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
