package com.example.onetomany.employee.usecase;

import com.example.onetomany.employee.dao.Employee;
import com.example.onetomany.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUseCaseImpl implements EmployeeUseCase {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findDetailEmployee(Integer id) {
        return employeeRepo.findById(id);
    }
}
