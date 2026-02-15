package com.capg.student;

public class StudentService {
	String grade = "";
	
	public int addStudentInfo(int id, String name, double marks) {
		System.out.println("----- This is Student Service -----");
		
		if(marks >= 90) {
			grade = "A";
		}else if(marks >= 80 && marks < 90) {
			grade = "B";
		}else if(marks >= 70 && marks < 80) {
			grade = "C";
		}else if(marks >= 60 && marks < 70) {
			grade = "D";
		}else if(marks >= 50 && marks < 60) {
			grade = "E";
		}else {
			grade = "F";
		}
		
		StudentBean s = new StudentBean();
		s.setStudentId(id);
		s.setName(name);
		s.setMarks(marks);
		s.setGrade(grade);
		
		StudentDao stu = new StudentDao();
		
		int result = stu.addStudents(s);
		System.out.println("Status => At Service : " + result);
		return result;
	}
}
