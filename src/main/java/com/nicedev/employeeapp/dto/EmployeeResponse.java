package com.nicedev.employeeapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeResponse {

    private Long id;
    private String name;
    private String email;
    private BigDecimal salary;
    private String department;

    public EmployeeResponse(Long id, String name, String email, BigDecimal salary, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }
}
