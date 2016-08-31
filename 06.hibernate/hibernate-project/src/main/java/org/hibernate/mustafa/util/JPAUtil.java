package org.hibernate.mustafa.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;
    private static JPAUtil jpaUtil = new JPAUtil();

    private JPAUtil(){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

}
