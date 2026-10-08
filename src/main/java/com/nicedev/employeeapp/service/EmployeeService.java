package com.nicedev.employeeapp.service;

import com.nicedev.employeeapp.dto.EmployeeRequest;
import com.nicedev.employeeapp.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest request);

    List<EmployeeResponse> findAll();

    EmployeeResponse findById(Long id);

    EmployeeResponse update(Long id, EmployeeRequest request);

    void delete(Long id);
}
