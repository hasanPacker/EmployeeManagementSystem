package com.nisum.employeemanagementsystem.Model.Employee;

import com.nisum.employeemanagementsystem.DTO.EmployeeDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EmployeeRequestModel {
    @NotNull(message ="Empty Payload")
    @Valid
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
