package com.springcore;

public class EmployeeServiceImpl implements EmployeeService {
	int id;
	String employee;
	String department;
	
	public EmployeeServiceImpl() {
		
	}
	
	public EmployeeServiceImpl(int id, String department, String employee) {
		this.id = id;
		this.department = department;
		this.employee = employee;
	}
	
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void allEmployees() {
		System.out.println("Employee Name is " + employee + "\nEmployee Id is " + id + "\nEmployee department is " + department);
	}
}
