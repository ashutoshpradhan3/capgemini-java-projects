package com.capg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class ResultSetNextExample {

    public static void main(String[] args) {
    	Connection conn = null;
    	String driver = "com.mysql.cj.jdbc.Driver";
    	
        String url = "jdbc:mysql://localhost:3306/capg";
        String userName = "root";
        String password = "Ashu1234@@";

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, userName, password);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employeeinfo1");

            while (rs.next()) {
                System.out.println("Employee No : " + rs.getInt("empno"));
                System.out.println("Employee Name : " + rs.getString("ename"));
                System.out.println("Employee Salary : " + rs.getInt("sal"));
                System.out.println("-------------------");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
