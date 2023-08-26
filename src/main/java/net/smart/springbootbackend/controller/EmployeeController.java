package net.smart.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.smart.springbootbackend.model.Employee;
import net.smart.springbootbackend.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        
        return employeeRepository.findAll();

    }

    @PostMapping("/employee")
    public Employee creatEmployee(@RequestBody Employee employee){
            return employeeRepository.save(employee);
    }


    
}
