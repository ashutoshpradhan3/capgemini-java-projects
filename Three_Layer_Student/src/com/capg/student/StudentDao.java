package com.capg.student;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

class StudentDao {
	int result;
	public int addStudents(StudentBean s) {
		System.out.println("----- Student DAO LAYER ---- ");
		System.out.println("Student Id : " + s.getStudentId());
		System.out.println("Student Name : " + s.getName());
		System.out.println("Student Marks : " + s.getMarks());
		System.out.println("Student Grade : " + s.getGrade());
		
		try {
			Connection conn = null;
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/capg";
			String userName = "root";
			String password = "Ashu1234@@";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			String query = "insert into student1 values(?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, s.getStudentId());
			pstmt.setString(2, s.getName());
			pstmt.setDouble(3, s.getMarks());
			pstmt.setString(4, s.getGrade());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
}
