package com.springboot.elasticsearch.controller;
import com.google.gson.Gson;
import com.springboot.elasticsearch.model.Employee;
import com.springboot.elasticsearch.service.Employeeserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/employee")
public class Mycontroller {

    @Autowired
    Employeeserv eserv;

    /**
     * Method to save the employees in the database.
     * @param myemployees
     * @return
     */
    @PostMapping(value= "/saveemployees")
    public String saveEmployee(@RequestBody List<Employee> myemployees) {
        eserv.saveEmployee(myemployees);
        return "Records saved in the db.";
    }

    /**
     * Method to fetch all employees from the database.
     * @return
     */
    @GetMapping(value= "/getall")
    public Iterable<Employee> getAllEmployees() {
        return eserv.findAllEmployees();
    }

    /**
     * Method to fetch the employee details on the basis of designation.
     * @param designation
     * @return
     */
    @GetMapping(value= "/findbydesignation/{employee-designation}")
    public Iterable<Employee> getByDesignation(@PathVariable(name= "employee-designation") String designation) {
        return eserv.findByDesignation(designation);
    }

    /**
     * Method to fetch the employee details on the basis of name.
     * @param name
     * @return
     */
    @GetMapping(value= "/findbyname/{employee-name}")
    public Iterable<Employee> getByName(@PathVariable(name= "employee-name") String name) {
        return eserv.findByName(name);
    }
}
