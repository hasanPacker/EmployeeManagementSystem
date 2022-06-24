package com.nisum.employeemanagementsystem.Controller;

import com.nisum.employeemanagementsystem.Model.EmployeeAttendance.EmployeeAttendanceRequestModel;
import com.nisum.employeemanagementsystem.Model.EmployeeAttendance.EmployeeAttendanceResponseModel;
import com.nisum.employeemanagementsystem.Model.EmployeeAttendance.EmployeeAttendancesResponseModel;
import com.nisum.employeemanagementsystem.Service.EmployeeAttendance.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/v1")
public class EmployeeAttendanceController {

    @Autowired
    EmployeeAttendanceService employeeAttendanceService;

    @GetMapping(value = "/employees/{employeeId}/Attendances")
    public EmployeeAttendancesResponseModel getEmployeeActivities(@PathVariable("employeeId") long employeeId){

        EmployeeAttendancesResponseModel responseModel  = new EmployeeAttendancesResponseModel();
        responseModel.setEmployeeAttendanceDTOs(employeeAttendanceService.getEmployeeActivities(employeeId));
        responseModel.setStatus(true);

        return responseModel;
    }

    @PostMapping(value="/employeeAttendances",
            produces = "application/json",
            consumes = "application/json")
    public EmployeeAttendanceResponseModel addEmployeeAttendance(@Valid @RequestBody EmployeeAttendanceRequestModel employeeAttendanceRequestModel){

        EmployeeAttendanceResponseModel responseModel = new EmployeeAttendanceResponseModel();
        responseModel.setEmployeeAttendanceDTO(employeeAttendanceService.addAttendance(employeeAttendanceRequestModel.getEmployeeAttendanceDTO()));
        responseModel.setStatus(true);

        return responseModel;
    }

}
