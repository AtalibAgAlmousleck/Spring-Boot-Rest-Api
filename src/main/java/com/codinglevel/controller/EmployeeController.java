package com.codinglevel.controller;

import com.codinglevel.entities.Employee;
import com.codinglevel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam Integer pageNumber,
                                                         @RequestParam Integer pageSize)   {
        return new ResponseEntity<>(employeeService.getEmployees(
                pageNumber,
                pageSize
        ), HttpStatus.OK);
    }

    @PostMapping(value =  "/save")
    public ResponseEntity<Employee> registration(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.registerEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id) {
       return new ResponseEntity<Employee>( employeeService.findEmployee(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        //employeeService.deleteEmployee(id),
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    //Update employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    //Find by Eployee Name
    @GetMapping(value = "/filter")
    public ResponseEntity<Employee> getEmployeeName(@RequestParam String name) {
        return new ResponseEntity<>(employeeService.findEmployeeByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/both")
    public ResponseEntity<List<Employee>> getNameAndDepartemtn(@RequestParam String name, String department) {
        return new ResponseEntity<>(employeeService.findNameAndDepartment(
                name, department
        ), HttpStatus.OK);
    }

}
