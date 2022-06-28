package com.nisum.employeemanagementsystem.Service.EmployeeAttendance;

import com.nisum.employeemanagementsystem.Custom.EmployeeException.EmployeeException;
import com.nisum.employeemanagementsystem.DTO.EmployeeAttendanceDTO;
import com.nisum.employeemanagementsystem.DTO.EmployeeDTO;
import com.nisum.employeemanagementsystem.Entity.Employee;
import com.nisum.employeemanagementsystem.Entity.EmployeeAttendance;
import com.nisum.employeemanagementsystem.Repository.EmployeeAttendanceRepository;
import com.nisum.employeemanagementsystem.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService{
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmployeeAttendanceRepository employeeAttendanceRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeAttendanceDTO addAttendance(EmployeeAttendanceDTO employeeAttendanceDTO) {
        Optional<Employee> employee = employeeRepository.findById(employeeAttendanceDTO.getEmployeeId());
        if(employee.isPresent()) {
            EmployeeAttendance employeeAttendance = ConvertToEntity(employeeAttendanceDTO);
            employeeAttendance.setEntryTime(new Date());
            employeeAttendance.setEmployee(employee.get());
            employeeAttendance = employeeAttendanceRepository.save(employeeAttendance);
            return ConvertToDTO(employeeAttendance);
        }
        throw new EmployeeException("No employee found");
    }

    @Override
    public List<EmployeeAttendanceDTO> getEmployeeActivities(long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){

            List<EmployeeAttendance> employeeAttendances = employeeAttendanceRepository.getAttendanceByEmployeeId(id);
            return employeeAttendances
                    .stream()
                    .map(this::ConvertToDTO)
                    .collect(Collectors.toList());
        }
        throw new EmployeeException("No employee found");
    }

    private EmployeeAttendance ConvertToEntity(EmployeeAttendanceDTO employeeAttendanceDTO){
        EmployeeAttendance employeeAttendance  = modelMapper.map(employeeAttendanceDTO,EmployeeAttendance.class);
        return employeeAttendance;
    }

    private EmployeeAttendanceDTO ConvertToDTO(EmployeeAttendance employeeAttendance){
        EmployeeAttendanceDTO employeeAttendanceDTO =modelMapper.map(employeeAttendance,EmployeeAttendanceDTO.class);
        return employeeAttendanceDTO;
    }
}
