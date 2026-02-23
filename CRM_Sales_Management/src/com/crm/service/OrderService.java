package com.crm.service;


import javax.persistence.*;
import java.util.*;
import java.time.LocalDate;

import com.crm.entity.*;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer == null) {
                System.out.println("Customer Not Found!");
                return;
            }

            List<Product> products = new ArrayList<>();
            double total = 0;

            for (Long pid : productIds) {
                Product product = em.find(Product.class, pid);
                if (product != null) {
                    products.add(product);
                    total += product.getPrice();
                }
            }

            OrderEntity order = new OrderEntity();
            order.setCustomer(customer);
            order.setProducts(products);
            order.setTotalAmount(total);
            order.setOrderDate(LocalDate.now());

            em.persist(order);

            tx.commit();
            System.out.println("Order Placed Successfully! Total = " + total);

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}