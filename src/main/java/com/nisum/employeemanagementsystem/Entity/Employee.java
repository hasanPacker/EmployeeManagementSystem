package com.nisum.employeemanagementsystem.Entity;

import com.nisum.employeemanagementsystem.Constant.Status;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private Date joiningDate;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String username;
    private String password;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<EmployeeAttendance> employeeAttendance;

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

    public List<EmployeeAttendance> getEmployeeAttendance() {
        return employeeAttendance;
    }

    public void setEmployeeAttendance(List<EmployeeAttendance> employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
