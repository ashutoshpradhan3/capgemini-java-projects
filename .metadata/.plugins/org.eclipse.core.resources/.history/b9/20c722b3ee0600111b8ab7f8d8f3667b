package com.capg.jdbc;

import java.sql.*;

public class PreparedStatementEx1 {

    public static void main(String[] args) throws Exception {

        System.out.println("MySQL PreparedStatement Example");

        String url = "jdbc:mysql://localhost:3306/capg";
        String userName = "root";
        String password = "Ashu1234@@";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, userName, password);

        String query = "INSERT INTO Employeeinfo1 (empno, ename, sal) VALUES (?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(query);

        // First execution
        pstmt.setInt(1, 555);
        pstmt.setString(2, "Babu");
        pstmt.setDouble(3, 9999.66);
        int i = pstmt.executeUpdate();
        System.out.println("Record inserted count : " + i);

        // Second execution
        pstmt.setInt(1, 222);
        pstmt.setString(2, "Bhanu");
        pstmt.setDouble(3, 5450.66);
        i = pstmt.executeUpdate();
        System.out.println("Query executed for the second time count : " + i);

        pstmt.close();
        conn.close();
    }
}
