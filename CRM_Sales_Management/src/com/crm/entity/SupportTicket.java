package com.crm.entity;


import javax.persistence.*;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueDescription;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public SupportTicket() {}

    public SupportTicket(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}