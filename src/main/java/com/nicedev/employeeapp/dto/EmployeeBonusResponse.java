package com.nicedev.employeeapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class EmployeeBonusResponse {

    private Long employeeId;
    private BigDecimal salary;
    private BigDecimal bonus;

}
