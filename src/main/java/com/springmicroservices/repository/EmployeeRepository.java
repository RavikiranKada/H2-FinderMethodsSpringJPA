package com.springmicroservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmicroservices.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findByEmpName(String name);
	List<Employee> findByEmpCity(String city);
	List<Employee> findByEmpSalaryGreaterThan(Integer salary);


}
