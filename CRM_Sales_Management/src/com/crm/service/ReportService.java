package com.crm.service;


import javax.persistence.*;
import java.util.*;

import com.crm.entity.*;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getEmployeePerformance(Long employeeId) {

        try {

            SalesEmployee emp = em.find(SalesEmployee.class, employeeId);

            if (emp == null) {
                System.out.println("Employee Not Found!");
                return;
            }

            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :empId",
                    Long.class);

            query.setParameter("empId", employeeId);

            Long leadCount = query.getSingleResult();

            System.out.println("Employee Performance Report");
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Total Leads Assigned: " + leadCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}