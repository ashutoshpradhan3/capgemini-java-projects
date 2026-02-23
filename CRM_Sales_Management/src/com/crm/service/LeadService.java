package com.crm.service;


import javax.persistence.*;
import com.crm.entity.*;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    public void createLead(String name, String source, String contactInfo) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Lead lead = new Lead(name, source, contactInfo);
            em.persist(lead);
            tx.commit();
            System.out.println("Lead Created!");
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee emp = em.find(SalesEmployee.class, employeeId);
            lead.setEmployee(emp);
            tx.commit();
            System.out.println("Lead Assigned!");
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public void convertLeadToCustomer(Long leadId) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Lead lead = em.find(Lead.class, leadId);
            Customer customer =
                    new Customer(lead.getName(), "converted@mail.com", lead.getContactInfo());
            em.persist(customer);
            tx.commit();
            System.out.println("Lead Converted to Customer!");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}