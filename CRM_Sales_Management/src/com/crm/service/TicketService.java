package com.crm.service;


import javax.persistence.*;
import com.crm.entity.*;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void raiseTicket(Long orderId, String issueDescription) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            OrderEntity order = em.find(OrderEntity.class, orderId);

            if (order == null) {
                System.out.println("Order Not Found!");
                return;
            }

            SupportTicket ticket = new SupportTicket(issueDescription);
            ticket.setOrder(order);

            em.persist(ticket);

            tx.commit();
            System.out.println("Support Ticket Raised Successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}