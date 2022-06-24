package com.nisum.employeemanagementsystem.DTO;

import com.nisum.employeemanagementsystem.Constant.AttendanceType;
import com.nisum.employeemanagementsystem.Custom.Validation.IForeignKeyValidator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EmployeeAttendanceDTO {
    private long id;
    @NotNull(message = "attendanceType cannot be null")
    private AttendanceType attendanceType;
    private Date entryTime;
    private  EmployeeDTO  employeeDTO;
    @Min(value=1,message = "employeeId cannot be null")
    @IForeignKeyValidator(className = "Employee",message = "employee not found")
    private long employeeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "EmployeeAttendanceDTO{" +
                "id=" + id +
                ", attendanceType=" + attendanceType +
                ", entryTime=" + entryTime +
                ", employeeDTO=" + employeeDTO +
                ", employeeId=" + employeeId +
                '}';
    }
}
