package com.asifanam.cruddemo.service;

import com.asifanam.cruddemo.dao.EmployeeRepository;
import com.asifanam.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {

        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Didn't find employee id - "+ theId);
        }

        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {

        return employeeRepository.save(theEmployee);
    }



    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);
    }
}
