package com.loginext.java;
import java.util.*;
import java.sql.*;


public class CustomerOrderManagementJDBC {
	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/loginext";
		String username = "root";
		String password = "Ashu1234@@";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		
		// step 1 -> Get total drivers
        Statement driverStmt = conn.createStatement();
        ResultSet drivers = driverStmt.executeQuery("SELECT driver_id FROM drivers ORDER BY driver_id");

        List<Integer> driverIds = new ArrayList<>();
        
        while (drivers.next()) {
            driverIds.add(drivers.getInt("driver_id"));
        }

        int M = driverIds.size();
        int[] driverFreeTime = new int[M]; 
			
        // Step 2 -> Get all orders sorted by order_time
        Statement orderStmt = conn.createStatement();
        ResultSet orders = orderStmt.executeQuery(
                "SELECT customer_id, order_time, travel_time FROM orders ORDER BY order_time");
        
        while (orders.next()) {

            int customerId = orders.getInt("customer_id");
            int orderTime = orders.getInt("order_time");
            int travelTime = orders.getInt("travel_time");

            boolean assigned = false;

            for (int i = 0; i < M; i++) {

                if (driverFreeTime[i] <= orderTime) {

                    System.out.println("C" + customerId + " - D" + driverIds.get(i));

                    driverFreeTime[i] = orderTime + travelTime;

                    //update DB driver free_time 
                    PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE drivers SET free_time=? WHERE driver_id=?");
                    updateStmt.setInt(1, driverFreeTime[i]);
                    updateStmt.setInt(2, driverIds.get(i));
                    updateStmt.executeUpdate();
                    
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.println("C" + customerId + " - No Food :-(");
            }
        }

        conn.close();
	}
}
