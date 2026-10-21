package com.nicedev.employeeapp.service;

import com.nicedev.employeeapp.dto.EmployeeResponse;
import com.nicedev.employeeapp.entity.Employee;
import com.nicedev.employeeapp.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    void shouldFindEmployee() {

        Employee employee = new Employee();

        employee.setId(1L);
        employee.setName("Kevin");

        when(repository.findById(1L))
                .thenReturn(Optional.of(employee));

        EmployeeResponse result =
                service.findById(1L);

        assertEquals("Kevin", result.getName());
    }
}
