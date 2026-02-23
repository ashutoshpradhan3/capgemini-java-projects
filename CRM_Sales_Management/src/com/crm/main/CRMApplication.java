package com.crm.main;


import java.util.*;
import javax.persistence.*;

import com.crm.service.*;
import com.crm.entity.*;
import com.crm.util.JPAUtil;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CRM MENU =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Customer ID: ");
                    Long custId = sc.nextLong();
                    sc.nextLine();

                    Address address = new Address();

                    System.out.print("Street: ");
                    address.setStreet(sc.nextLine());
                    System.out.print("City: ");
                    address.setCity(sc.nextLine());
                    System.out.print("State: ");
                    address.setState(sc.nextLine());
                    System.out.print("Zip Code: ");
                    address.setZipCode(sc.nextLine());

                    EntityTransaction tx = em.getTransaction();
                    try {
                        tx.begin();
                        Customer c = em.find(Customer.class, custId);

                        if (c == null) {
                            System.out.println("Customer Not Found!");
                            tx.rollback();
                            break;
                        }

                        c.setAddress(address);
                        em.persist(address);

                        tx.commit();
                        System.out.println("Address Added Successfully!");
                    } catch (Exception e) {
                        tx.rollback();
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.print("Lead Name: ");
                    String leadName = sc.nextLine();
                    System.out.print("Source: ");
                    String source = sc.nextLine();
                    System.out.print("Contact Info: ");
                    String contact = sc.nextLine();
                    leadService.createLead(leadName, source, contact);
                    break;

                case 4:
                    System.out.print("Lead ID: ");
                    Long leadId = sc.nextLong();
                    System.out.print("Employee ID: ");
                    Long empId = sc.nextLong();
                    sc.nextLine();
                    leadService.assignLeadToEmployee(leadId, empId);
                    break;

                case 5:
                    System.out.print("Lead ID: ");
                    Long convertId = sc.nextLong();
                    sc.nextLine();
                    leadService.convertLeadToCustomer(convertId);
                    break;

                case 6:
                    System.out.print("Product Name: ");
                    String prodName = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    productService.addProduct(prodName, price);
                    break;

                case 7:
                    System.out.print("Customer ID: ");
                    Long orderCustId = sc.nextLong();

                    System.out.print("Number of Products: ");
                    int count = sc.nextInt();

                    List<Long> productIds = new ArrayList<>();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter Product ID: ");
                        productIds.add(sc.nextLong());
                    }
                    sc.nextLine();

                    orderService.placeOrder(orderCustId, productIds);
                    break;

                case 8:
                    System.out.print("Order ID: ");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Issue Description: ");
                    String issue = sc.nextLine();
                    ticketService.raiseTicket(orderId, issue);
                    break;

                case 9:
                    System.out.print("Employee ID: ");
                    Long reportEmpId = sc.nextLong();
                    sc.nextLine();
                    reportService.getEmployeePerformance(reportEmpId);
                    break;

                case 10:
                    em.close();
                    JPAUtil.closeFactory();
                    System.out.println("Exiting CRM System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}