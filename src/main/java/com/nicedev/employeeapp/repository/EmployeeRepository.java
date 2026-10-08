package com.nicedev.employeeapp.repository;

import com.nicedev.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
    @Procedure(procedureName = "sp_calcular_bono")
    BigDecimal calcularBono(
            @Param("p_employee_id") Long employeeId
    );
}
