package com.crm.entity;


import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public OrderEntity() {}

    public Long getId() { return id; }

    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setProducts(List<Product> products) { this.products = products; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
}