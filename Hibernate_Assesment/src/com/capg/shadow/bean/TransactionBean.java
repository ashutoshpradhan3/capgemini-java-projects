package com.capg.shadow.bean;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class TransactionBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int accno;

    private String transaction;

    public TransactionBean() {}

    public TransactionBean(int accno, String transaction) {
        this.accno = accno;
        this.transaction = transaction;
    }

    public int getId() { return id; }
    public int getAccno() { return accno; }
    public String getTransaction() { return transaction; }
}