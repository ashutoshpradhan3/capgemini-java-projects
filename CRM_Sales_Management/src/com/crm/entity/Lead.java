package com.crm.entity;

import javax.persistence.*;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String source;
    private String contactInfo;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private SalesEmployee employee;

    public Lead() {}

    public Lead(String name, String source, String contactInfo) {
        this.name = name;
        this.source = source;
        this.contactInfo = contactInfo;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }

    public void setEmployee(SalesEmployee employee) {
        this.employee = employee;
    }
}