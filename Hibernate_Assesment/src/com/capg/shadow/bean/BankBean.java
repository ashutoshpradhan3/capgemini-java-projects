package com.capg.shadow.bean;

import javax.persistence.*;

@Entity
@Table(name = "bank_database")
public class BankBean {

    @Id
    @Column(name = "accno")
    private int accountNumber;

    @Column(name = "name")
    private String customerName;

    @Column(name = "mobile")
    private long mobileNumber;

    @Column(name = "balance")
    private double balance;

    public BankBean() {}

    public BankBean(int accountNumber, String customerName, long mobileNumber, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public long getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(long mobileNumber) { this.mobileNumber = mobileNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}