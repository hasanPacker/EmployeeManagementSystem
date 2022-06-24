package com.nisum.employeemanagementsystem.Service.EmployeeAttendance;

import com.nisum.employeemanagementsystem.DTO.EmployeeAttendanceDTO;

import java.util.List;

public interface EmployeeAttendanceService {
    EmployeeAttendanceDTO addAttendance(EmployeeAttendanceDTO employeeAttendanceDTO);
    List<EmployeeAttendanceDTO> getEmployeeActivities(long id);
}
