package com.capg.student;

import java.io.Serializable;

class StudentBean implements Serializable{
	private int studentId;
	private String name;
	private double marks;
	private String grade;
	
	public StudentBean() {
		
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMarks() {
		return marks;
	}
	
	public String getGrade() {
		return grade;
	}
}
