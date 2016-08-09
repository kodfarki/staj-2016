package org.hibernate.zahit;

import org.hibernate.zahit.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by GUNEY on 9.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mzg");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person();
        person.setId(1);
        person.setName("za");
        person.setSurname("gun");

        em.persist(person);
        em.getTransaction().commit();

    }
}
