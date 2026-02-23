package com.loginext.java;

import java.util.*;


public class CustomerOrderManagement {
	public static void main(String[] args) {
		
		//I am using the dummy data which was given in the Problem Statement
		//This same thing can be done by taking the user input while running the program using scanner
		
		int N = 6; // number Of Customers
		int M = 2; // number of drivers
		
		int[][] orders = {{1, 10},{4, 20},{15, 5},{22, 20},{24, 10},{25, 10}};
		
		
		// this array will track when the driver is free so that he can be allocated with new order
		int[] driverFreeTime = new int[M];
		
		
		// for each order I will check whether any of the driver is free or not starting from the 0th index
		for(int i=0;i<N;i++) {
			int orderTime = orders[i][0];
			int deliveryDuration = orders[i][1];
			
			//Now I will check , if any driver is free for this order or not ?
			// I will do that by traversing on the driver;
			
			
			//isDelivered will track whether order can be delivered or not 
			boolean isDelivered = false;
			
			for(int j=0;j<M;j++) {
				//if Driver is not occupied than he will accept the order
				if(driverFreeTime[j] <= orderTime) {
					driverFreeTime[j] = orderTime + deliveryDuration;
					
					System.out.println("C" + (i + 1) + " - " + "D" + (j + 1));
					isDelivered = true;
					break;
				}
				
			}
			
			// if Order not delivered than print this line 
			if(!isDelivered) {
				System.out.println("C" + (i + 1) + " - No Food :-(" );
			}
		}
	}
}
