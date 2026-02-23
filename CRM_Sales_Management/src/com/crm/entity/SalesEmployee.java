package com.crm.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class SalesEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "employee")
    private List<Lead> leads;

    public SalesEmployee() {}

    public SalesEmployee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Long getId() { return id; }
}