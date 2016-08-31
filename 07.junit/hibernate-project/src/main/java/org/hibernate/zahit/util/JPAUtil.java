package org.hibernate.zahit.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by GUNEY on 10.08.2016.
 */
public class JPAUtil {
    private static EntityManagerFactory emf;
    private static JPAUtil jpaUtil = new JPAUtil();

    private JPAUtil() {
        try {
            emf = Persistence.createEntityManagerFactory("mzg");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        JPAUtil.emf = emf;
    }
}
