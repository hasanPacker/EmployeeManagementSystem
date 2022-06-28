package com.nisum.employeemanagementsystem.Service.Employee;

import com.nisum.employeemanagementsystem.Custom.EmployeeException.EmployeeException;
import com.nisum.employeemanagementsystem.DTO.EmployeeDTO;
import com.nisum.employeemanagementsystem.Entity.Employee;
import com.nisum.employeemanagementsystem.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = employeeRepository.save(ConvertToEntity(employeeDTO));
        return ConvertToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(long id,EmployeeDTO employeeDTO) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            Employee savedEmployee = employee.get();

            savedEmployee.setName(employeeDTO.getName());
            savedEmployee.setAge(employeeDTO.getAge());
            savedEmployee.setStatus(employeeDTO.getStatus());
            savedEmployee.setJoiningDate(employeeDTO.getJoiningDate());
            savedEmployee.getEmployeeAttendance();
            employeeRepository.save(savedEmployee);
            return ConvertToDTO(savedEmployee);
        }
        throw new EmployeeException("No employee found");
    }

    @Override
    public List<EmployeeDTO> getEmployees() {

        List<EmployeeDTO> employeeDTOS = employeeRepository.findAll().stream().map(this::ConvertToDTO).collect(Collectors.toList());
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {

            return ConvertToDTO(employee.get());
        }
        throw new EmployeeException("No employee found");
    }

    @Override
    public boolean deleteEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return true;
        }
        throw new EmployeeException("No employee found");
    }

    private Employee ConvertToEntity(EmployeeDTO employeeDTO){
        Employee employee  = modelMapper.map(employeeDTO,Employee.class);
        return employee;
    }

    private EmployeeDTO ConvertToDTO(Employee employee){
        EmployeeDTO employeeDTO =modelMapper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }

}
