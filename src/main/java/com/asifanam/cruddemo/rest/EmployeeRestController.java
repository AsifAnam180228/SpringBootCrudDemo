package com.asifanam.cruddemo.rest;
import com.asifanam.cruddemo.entity.Employee;
import com.asifanam.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return theEmployee;
    }
    //add mapping for POST/employees - add new employee

    @PostMapping("/employees/{employeeId}")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //also just in case they pass an id in JSON  .. set id to 0
        //this is to focus a save of new item .. instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }


}
