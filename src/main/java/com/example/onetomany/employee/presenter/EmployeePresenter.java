package com.example.onetomany.employee.presenter;

import com.example.onetomany.employee.dao.Employee;
import com.example.onetomany.employee.dto.DetailEmployeeDto;
import com.example.onetomany.employee.dto.ListEmployeeDto;
import com.example.onetomany.employee.usecase.EmployeeUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class EmployeePresenter {
    @Autowired
    EmployeeUseCaseImpl employeeUseCaseImpl;

    @GetMapping("employee")
    public Map<String, Object> getAllEmployees() {
        Map<String, Object> map = new HashMap<>();
        List<Employee> employees = employeeUseCaseImpl.findAllEmployees();
        List<ListEmployeeDto> listEmployeeDtos = mapperToListEmployeeDto(employees);

        map.put("total", listEmployeeDtos.size());
        map.put("count", listEmployeeDtos.size());
        map.put("data", listEmployeeDtos);
        return map;
    }

    @GetMapping("employee/{id}")
    public Map<String, Object> getDetailEmployee(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        Optional<Employee> employee = employeeUseCaseImpl.findDetailEmployee(id);
        DetailEmployeeDto detailEmployeeDto = mapperToDetailEmployeeDto(employee);

        map.put("data", detailEmployeeDto);
        return map;
    }

    // Mapper ListEmployee to DTO
    private List<ListEmployeeDto> mapperToListEmployeeDto(List<Employee> employeeList) {
        ModelMapper modelMapper = new ModelMapper();
        List<ListEmployeeDto> listEmployeeDtos = new ArrayList<>();

        for(Employee employee: employeeList) {
            ListEmployeeDto listEmployeeDto = modelMapper.map(employee, ListEmployeeDto.class);
            listEmployeeDto.setEmployeeId(employee.getEmployeeId());
            listEmployeeDto.setEmployeeName(employee.getEmployeeName());
            listEmployeeDtos.add(listEmployeeDto);
        }

        return listEmployeeDtos;
    }

    // Mapper DetailEmployee to DTO
    private DetailEmployeeDto mapperToDetailEmployeeDto(Optional<Employee> employee) {
        ModelMapper modelMapper = new ModelMapper();
        DetailEmployeeDto detailEmployeeDto = modelMapper.map(employee, DetailEmployeeDto.class);
        employee.ifPresent(existEmpl -> {
            detailEmployeeDto.setEmployeeId(existEmpl.getEmployeeId());
            detailEmployeeDto.setEmployeeName(existEmpl.getEmployeeName());
            detailEmployeeDto.setEmployeeAddress(existEmpl.getEmployeeAddress());
            detailEmployeeDto.setEmployeeEmail(existEmpl.getEmployeeEmail());
        });

        return detailEmployeeDto;
    }
}
