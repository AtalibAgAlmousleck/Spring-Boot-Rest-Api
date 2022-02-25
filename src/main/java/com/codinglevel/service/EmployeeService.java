package com.codinglevel.service;

import com.codinglevel.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee registerEmployee(Employee employee);

    Employee findEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    Employee findEmployeeByName(String name);

    List<Employee> findNameAndDepartment(String name, String department);
}
