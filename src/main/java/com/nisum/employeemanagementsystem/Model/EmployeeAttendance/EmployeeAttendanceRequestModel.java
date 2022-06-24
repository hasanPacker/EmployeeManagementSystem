package com.nisum.employeemanagementsystem.Model.EmployeeAttendance;

import com.nisum.employeemanagementsystem.DTO.EmployeeAttendanceDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EmployeeAttendanceRequestModel {

    @Valid
    @NotNull(message = "Empty Payload")
    private EmployeeAttendanceDTO employeeAttendanceDTO;

    public EmployeeAttendanceDTO getEmployeeAttendanceDTO() {
        return employeeAttendanceDTO;
    }

    public void setEmployeeAttendanceDTO(EmployeeAttendanceDTO employeeAttendanceDTO) {
        this.employeeAttendanceDTO = employeeAttendanceDTO;
    }

    @Override
    public String toString() {
        return "EmployeeAttendanceRequestModel{" +
                "employeeAttendanceDTO=" + employeeAttendanceDTO +
                '}';
    }
}
