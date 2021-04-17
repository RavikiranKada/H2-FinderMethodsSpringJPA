package com.springmicroservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservices.model.Employee;
import com.springmicroservices.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees/employeeid/{empId}")
	public Employee getEmployeebyName(@PathVariable("empId") Integer empId) {
		
		//If the ID you are trying to look for is not present then 
		//you will get "java.util.NoSuchElementException: No value present" exception when no value is present
		
		System.out.println(employeeRepository.findById(empId));
		Optional<Employee> empListByName = employeeRepository.findById(empId);
		return empListByName.get();
	}

	
	@GetMapping("/employees/employeename/{empName}")
	public List<Employee> getEmployeebyName(@PathVariable("empName") String empName) {
		
		System.out.println(employeeRepository.findByEmpName(empName));
		List<Employee> empListByName = employeeRepository.findByEmpName(empName);
		return empListByName;
	}
	
	@GetMapping("/employees/employeecity/{empCity}")
	public List<Employee> getEmployeebyCity(@PathVariable("empCity") String empCity) {
		
		System.out.println(employeeRepository.findByEmpCity(empCity));
		List<Employee> empListByCity = employeeRepository.findByEmpCity(empCity);
		return empListByCity;
	}

	@GetMapping("/employees/salary/{minSalary}")
	public List<Employee> getEmployeesBasedOnSalary(@PathVariable("minSalary") Integer salary) {
		
		List<Employee> empListByMinSalary = employeeRepository.findByEmpSalaryGreaterThan(salary);
		System.out.println(empListByMinSalary);
		return empListByMinSalary;
	}
	
}
