package com.capgemini.lambda.client;

import com.capgemini.lambda.model.Employee;

import java.util.Comparator;
import java.util.TreeSet;

public class EmployeeClient {

	public static void main(String[] args) {

		Comparator<Employee> c = (e1,e2) -> Integer.compare(e1.getEmployeeId(), e2.getEmployeeId());
		
		
		
		TreeSet<Employee> employees = new TreeSet<>(c);
		employees.add(new Employee(101, "Alex", "HR", 34000));
		employees.add(new Employee(56, "Sam", "Admin", 78000));
		employees.add(new Employee(33, "Bob", "Admin", 55000));
		employees.add(new Employee(78, "Grant", "HR", 85600));
		employees.add(new Employee(104, "Taylor", "HR", 10000));

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
