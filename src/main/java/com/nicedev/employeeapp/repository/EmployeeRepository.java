package com.nicedev.employeeapp.repository;

import com.nicedev.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}
