package com.springmicroservices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springmicroservices.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class H2FinderMethodsSpringJpaApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Test
	void testSampleFinderMethod() {
		
		System.out.println(employeeRepository.findByEmpName("Ravi"));
	}
}
