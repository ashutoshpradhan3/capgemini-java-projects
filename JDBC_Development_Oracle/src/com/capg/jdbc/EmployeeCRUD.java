package com.capg.jdbc;

import java.sql.*;

public class EmployeeCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/capg";
    static final String USER = "root";
    static final String PASS = "Ashu1234@@";

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASS);

        insertEmployee(conn);
        readEmployees(conn);
        updateEmployee(conn);
        deleteEmployee(conn);

        conn.close();
    }

    // CREATE
    static void insertEmployee(Connection conn) throws SQLException {
        String sql = "INSERT INTO Employeeinfo1 VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, 301);
        ps.setString(2, "Ravi");
        ps.setDouble(3, 65000);
        ps.executeUpdate();

        System.out.println("INSERT operation completed");
        ps.close();
    }

    // READ
    static void readEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Employeeinfo1";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\nEMPLOYEE DETAILS");
        while (rs.next()) {
            System.out.println(
                rs.getInt("empno") + "  " +
                rs.getString("ename") + "  " +
                rs.getDouble("sal")
            );
        }

        rs.close();
        st.close();
    }

    // UPDATE
    static void updateEmployee(Connection conn) throws SQLException {
        String sql = "UPDATE Employeeinfo1 SET sal = ? WHERE empno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, 72000);
        ps.setInt(2, 103);
        int count = ps.executeUpdate();

        System.out.println("\nUPDATE count : " + count);
        ps.close();
    }

    // DELETE
    static void deleteEmployee(Connection conn) throws SQLException {
        String sql = "DELETE FROM Employeeinfo1 WHERE empno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, 103);
        int count = ps.executeUpdate();

        System.out.println("\nDELETE count : " + count);
        ps.close();
    }
}
