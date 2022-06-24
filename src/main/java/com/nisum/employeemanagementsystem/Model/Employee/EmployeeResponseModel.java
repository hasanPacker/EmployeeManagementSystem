package com.nisum.employeemanagementsystem.Model.Employee;

import com.nisum.employeemanagementsystem.DTO.EmployeeDTO;
import com.nisum.employeemanagementsystem.Model.GenericResponse;

public class EmployeeResponseModel extends GenericResponse {
    private EmployeeDTO employeeDTO;

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public String toString() {
        return "EmployeeResponseModel{" +
                "employeeDTO=" + employeeDTO +
                '}';
    }
}
