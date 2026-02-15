package com.capg.shadow.dao;

import com.capg.shadow.bean.BankBean;
import java.util.List;

public interface BankDao {

    void createAccount(BankBean bean);
    BankBean findAccount(int accNo);
    void updateAccount(BankBean bean);
    void addTransaction(int accNo, String message);
    List<String> getTransactions(int accNo);
}