package com.nisum.employeemanagementsystem.Service.Employee;

import com.nisum.employeemanagementsystem.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(long id, EmployeeDTO employeeDTO);
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeById(long id);
    boolean deleteEmployeeById(long id);
}
