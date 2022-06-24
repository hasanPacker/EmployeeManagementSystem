package com.nisum.employeemanagementsystem.Controller;

import com.nisum.employeemanagementsystem.Model.Employee.EmployeeRequestModel;
import com.nisum.employeemanagementsystem.Model.Employee.EmployeeResponseModel;
import com.nisum.employeemanagementsystem.Model.Employee.EmployeesResponseModel;
import com.nisum.employeemanagementsystem.Model.GenericResponse;
import com.nisum.employeemanagementsystem.Service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value ="/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees")
    private EmployeesResponseModel getEmployees(){
        EmployeesResponseModel employeesResponseModel = new EmployeesResponseModel();
        employeesResponseModel.setEmployeesDTO(employeeService.getEmployees());
        employeesResponseModel.setStatus(true);

        return employeesResponseModel;
    }

    @PostMapping(value = "/employees")
    private EmployeeResponseModel addEmployee(@Valid @RequestBody EmployeeRequestModel employeeRequestModel){
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();

        employeeResponseModel.setEmployeeDTO(employeeService.addEmployee(employeeRequestModel.getEmployeeDTO()));
        employeeResponseModel.setStatus(true);

        return employeeResponseModel;
    }

    @PutMapping(value = "/employees/{employeeId}",
            produces = "application/json",
            consumes = "application/json")
    private EmployeeResponseModel updateEmployee(@PathVariable("employeeId") long employeeId, @RequestBody EmployeeRequestModel employeeRequestModel){
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();

        employeeResponseModel.setEmployeeDTO(employeeService.updateEmployee(employeeId,employeeRequestModel.getEmployeeDTO()));
        employeeResponseModel.setStatus(true);

        return employeeResponseModel;
    }

    @GetMapping(value = "/employees/{employeeId}")
    private EmployeeResponseModel getEmployeeById(@PathVariable("employeeId") long employeeId){
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        employeeResponseModel.setEmployeeDTO(employeeService.getEmployeeById(employeeId));
        employeeResponseModel.setStatus(true);

        return employeeResponseModel;
    }

    @DeleteMapping(value = "/employees/{employeeId}")
    private GenericResponse deleteEmployee(@PathVariable("employeeId") long employeeId){
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setStatus(employeeService.deleteEmployeeById(employeeId));

        return genericResponse;
    }
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
