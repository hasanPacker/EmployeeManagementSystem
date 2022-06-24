package com.nisum.employeemanagementsystem.Model.EmployeeAttendance;

import com.nisum.employeemanagementsystem.DTO.EmployeeAttendanceDTO;
import com.nisum.employeemanagementsystem.Model.GenericResponse;

public class EmployeeAttendanceResponseModel extends GenericResponse {
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
