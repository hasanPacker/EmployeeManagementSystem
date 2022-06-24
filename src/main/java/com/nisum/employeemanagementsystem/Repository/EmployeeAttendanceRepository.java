package com.nisum.employeemanagementsystem.Repository;

import com.nisum.employeemanagementsystem.Entity.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance,Long> {

    @Query("select att from EmployeeAttendance att where att.employee.id = :id")
    List<EmployeeAttendance> getAttendanceByEmployeeId(@Param(value = "id") long id);
}
