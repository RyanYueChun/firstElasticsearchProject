package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.model.Employee;

import java.util.List;

public interface Employeeserv {

    public void saveEmployee(List<Employee> employees);
    public Iterable<Employee> findAllEmployees();
    public List<Employee> findByDesignation(String designation);
    public List<Employee> findByName(String name);
}
