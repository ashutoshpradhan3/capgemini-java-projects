package com.capg.shadow.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.stream.Collectors;

import com.capg.shadow.bean.BankBean;
import com.capg.shadow.bean.TransactionBean;
import com.capg.shadow.util.HibernateUtil;

import java.util.List;

public class BankConnnectionDao implements BankDao {

	private Session getSession() {
	    return HibernateUtil.getSessionFactory().openSession();
	}

    @Override
    public void createAccount(BankBean bean) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(bean);
        tx.commit();
        session.close();
    }

    @Override
    public BankBean findAccount(int accNo) {
        Session session = getSession();
        BankBean bean = session.get(BankBean.class, accNo);
        session.close();
        return bean;
    }

    @Override
    public void updateAccount(BankBean bean) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.update(bean);
        tx.commit();
        session.close();
    }

    @Override
    public void addTransaction(int accNo, String message) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(new TransactionBean(accNo, message));
        tx.commit();
        session.close();
    }
    
    @Override
    public List<String> getTransactions(int accNo) {
        Session session = getSession();

        List<TransactionBean> list = session
                .createQuery("from TransactionBean where accno = :acc", TransactionBean.class)
                .setParameter("acc", accNo)
                .getResultList();

        session.close();

        return list.stream()
                   .map(TransactionBean::getTransaction)
                   .collect(Collectors.toList());
    }
}