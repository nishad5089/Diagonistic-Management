package com.diagnosticbillmanagement.diagnosticbillmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DiagnosticbillmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiagnosticbillmanagementApplication.class, args);
    }

}
