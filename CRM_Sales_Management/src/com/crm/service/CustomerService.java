package com.crm.service;



import javax.persistence.*;
import com.crm.entity.*;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Customer customer = new Customer(name, email, phone);
            em.persist(customer);
            tx.commit();
            System.out.println("Customer Registered Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}