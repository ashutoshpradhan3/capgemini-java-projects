package com.crm.util;

import javax.persistence.*;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("crmPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeFactory() {
        emf.close();
    }
}