package com.query.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.query.entity.Employee;
import com.query.repository.EmployeeRepository;
@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	EmployeeRepository  repository;

	@Override
	public void run(String... args) throws Exception {
		
		List<Employee> empList=repository.findByDeptno(20);
		empList.forEach(e -> System.out.println(e));
		
		List<Object[]>  empList2=repository.readEmployees();
		empList2.forEach(obj -> System.out.println(obj[0]+","+obj[1]));
		
		List<Employee>  empList3=repository.getEmployeesBySal(10000.0);
		empList3.forEach(e -> System.out.println(e));
		
		int count=repository.updateEmployees(9999.0, 10);
		System.out.println("No of employees updated = "+count);
	}

}
