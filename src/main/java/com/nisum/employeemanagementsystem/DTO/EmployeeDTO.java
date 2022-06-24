package com.nisum.employeemanagementsystem.DTO;

import com.nisum.employeemanagementsystem.Constant.Status;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class EmployeeDTO {
    private long id;
    @NotNull(message = "Name cannot be null")
    private String name;
   @Min(value = 18,message = "age must be more than or equal to 18")
    private int age;
    @NotNull(message = "joiningDate cannot be null")
    private Date joiningDate;
    @NotNull(message = "status cannot be null")
    private Status status;

    private List<EmployeeAttendanceDTO> employeeAttendance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<EmployeeAttendanceDTO> getEmployeeAttendance() {
        return employeeAttendance;
    }

    public void setEmployeeAttendance(List<EmployeeAttendanceDTO> employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", joiningDate=" + joiningDate +
                ", status=" + status +
                ", employeeAttendance=" + employeeAttendance +
                '}';
    }
}
