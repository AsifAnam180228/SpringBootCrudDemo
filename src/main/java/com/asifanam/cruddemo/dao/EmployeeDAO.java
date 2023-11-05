package com.asifanam.cruddemo.dao;

import com.asifanam.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
