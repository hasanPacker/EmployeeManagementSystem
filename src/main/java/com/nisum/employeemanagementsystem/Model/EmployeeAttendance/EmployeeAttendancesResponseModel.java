package com.nisum.employeemanagementsystem.Model.EmployeeAttendance;

import com.nisum.employeemanagementsystem.DTO.EmployeeAttendanceDTO;
import com.nisum.employeemanagementsystem.Model.GenericResponse;

import java.util.List;

public class EmployeeAttendancesResponseModel extends GenericResponse {
    List<EmployeeAttendanceDTO> employeeAttendanceDTOs;

    public List<EmployeeAttendanceDTO> getEmployeeAttendanceDTOs() {
        return employeeAttendanceDTOs;
    }

    public void setEmployeeAttendanceDTOs(List<EmployeeAttendanceDTO> employeeAttendanceDTOs) {
        this.employeeAttendanceDTOs = employeeAttendanceDTOs;
    }

    @Override
    public String toString() {
        return "EmployeeAttendancesResponseModel{" +
                "employeeAttendanceDTOs=" + employeeAttendanceDTOs +
                '}';
    }
}
