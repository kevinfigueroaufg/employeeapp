package com.nicedev.employeeapp.service;

import com.nicedev.employeeapp.dto.EmployeeBonusResponse;
import com.nicedev.employeeapp.dto.EmployeeRequest;
import com.nicedev.employeeapp.dto.EmployeeResponse;
import com.nicedev.employeeapp.entity.Employee;
import com.nicedev.employeeapp.exception.EmployeeNotFoundException;
import com.nicedev.employeeapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public EmployeeResponse create(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(request.getDepartment());

        Employee saved = repository.save(employee);

        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse findById(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        return toResponse(employee);
    }

    @Override
    @Transactional
    public EmployeeResponse update(
            Long id,
            EmployeeRequest request) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(request.getDepartment());

        return toResponse(employee);
    }

    @Override
    @Transactional
    public EmployeeResponse patch(Long id, EmployeeRequest request) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        if (request.getName() != null) {
            employee.setName(request.getName());
        }

        if (request.getEmail() != null) {
            employee.setEmail(request.getEmail());
        }

        if (request.getSalary() != null) {
            employee.setSalary(request.getSalary());
        }

        if (request.getDepartment() != null) {
            employee.setDepartment(request.getDepartment());
        }

        return toResponse(employee);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }

        repository.deleteById(id);
    }

    @Override
    public EmployeeBonusResponse calcularBono(Long employeeId) {

        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        BigDecimal bono = repository.calcularBono(employeeId);

        return EmployeeBonusResponse.builder()
                .employeeId(employee.getId())
                .salary(employee.getSalary())
                .bonus(bono)
                .build();
    }

    private EmployeeResponse toResponse(Employee e) {

        return new EmployeeResponse(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getSalary(),
                e.getDepartment()
        );
    }
}
