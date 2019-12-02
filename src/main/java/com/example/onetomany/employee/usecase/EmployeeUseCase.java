package com.example.onetomany.employee.usecase;

import com.example.onetomany.employee.dao.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeUseCase {
    List<Employee> findAllEmployees();
    Optional<Employee> findDetailEmployee(Integer id);
}
