package com.codinglevel.repository;

import com.codinglevel.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    Employee findByName(String name);

    List<Employee> findByNameAndDepartment(String name, String department);
}
