package com.nisum.employeemanagementsystem.Model.Employee;

import com.nisum.employeemanagementsystem.DTO.EmployeeDTO;
import com.nisum.employeemanagementsystem.Model.GenericResponse;

import java.util.List;

public class EmployeesResponseModel extends GenericResponse {
    List<EmployeeDTO> employeesDTO;

    public List<EmployeeDTO> getEmployeesDTO() {
        return employeesDTO;
    }

    public void setEmployeesDTO(List<EmployeeDTO> employeesDTO) {
        this.employeesDTO = employeesDTO;
    }

    @Override
    public String toString() {
        return "EmployeesResponseModel{" +
                "employeesDTO=" + employeesDTO +
                '}';
    }
}
