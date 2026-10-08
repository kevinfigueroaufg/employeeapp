package com.nicedev.employeeapp.service;

import com.nicedev.employeeapp.dto.EmployeeBonusResponse;
import com.nicedev.employeeapp.dto.EmployeeRequest;
import com.nicedev.employeeapp.dto.EmployeeResponse;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest request);

    List<EmployeeResponse> findAll();

    EmployeeResponse findById(Long id);

    EmployeeResponse update(Long id, EmployeeRequest request);

    EmployeeResponse patch(Long id, EmployeeRequest request);

    void delete(Long id);

    EmployeeBonusResponse calcularBono(Long employeeId);
}
