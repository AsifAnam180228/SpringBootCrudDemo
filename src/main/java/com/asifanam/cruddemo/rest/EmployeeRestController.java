package com.asifanam.cruddemo.rest;
import com.asifanam.cruddemo.entity.Employee;
import com.asifanam.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    //quick and dirty: inject employee dao

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService= theEmployeeService;
    }

    //expose "/employees" and return a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}