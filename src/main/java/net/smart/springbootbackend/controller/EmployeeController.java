package net.smart.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.smart.springbootbackend.model.Employee;
import net.smart.springbootbackend.repository.EmployeeRepository;
import net.smart.springbootbackend.exception.ResousourceNotFoundException;
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    //build get all employeeS REST API
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        
        return employeeRepository.findAll();

    }

    //build create employee REST API
    @PostMapping("/employee")
    public Employee creatEmployee(@RequestBody Employee employee){
            return employeeRepository.save(employee);
    }


    //build find employee by ID REST API
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResousourceNotFoundException("Employee not exist with id: " +id));

        return ResponseEntity.ok(employee);
    }


     //build update employee REST API
     @PutMapping("/update/{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){

        Employee updateEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResousourceNotFoundException("Employee not exist with id: "+id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);

     }

     //build delete employee REST API
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResousourceNotFoundException("Employee not exist with id: " +id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
     }
    
}
