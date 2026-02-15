package com.capg.student;

import java.util.Scanner;

public class StudentController {
	public static void main(String[] args) {
		System.out.println("----- This is Student controller ----- ");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter unique Id : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Your name : ");
		String name = sc.nextLine();
		
		System.out.print("Enter Your marks, marks should be <= 100 : ");
		double marks = sc.nextDouble();
		
		StudentService s = new StudentService();
		int output = s.addStudentInfo(id, name, marks);
		
		System.out.println("Status => At Controller : " + output);
	}
}
