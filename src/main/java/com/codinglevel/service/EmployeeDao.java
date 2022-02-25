package com.codinglevel.service;

import com.codinglevel.entities.Employee;
import com.codinglevel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDao implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDao(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Override
//    public List<Employee> getEmployees(int pageNumber, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        return employeeRepository.findAll(pageable).getContent();
//    }

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,  Sort.Direction.DESC, "id");
        return employeeRepository.findAll(pageable).getContent();
    }

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee with id " + id + " does not exist");
    }

    @Override
    public void deleteEmployee(Long id) {
        boolean ifEmployeeExist = employeeRepository.existsById(id);
        if(!ifEmployeeExist) {
            throw new RuntimeException("Employee with id " + id + " does not exist");
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        String existingName = String.valueOf(employeeRepository.findByName(name));
        if(existingName.isEmpty()) {
            throw new RuntimeException("Employee with name : " + name + " does not exist");
        }
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findNameAndDepartment(String name, String department) {
        return employeeRepository.findByNameAndDepartment(name, department);
    }


}
