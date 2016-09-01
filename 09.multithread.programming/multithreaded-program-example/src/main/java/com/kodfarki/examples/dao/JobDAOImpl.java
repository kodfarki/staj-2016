package com.kodfarki.examples.dao;

import com.kodfarki.examples.model.Job;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JobDAOImpl implements JobDAO {

    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Job job) {
        entityManager.persist(job);
    }


    @Override
    @Transactional
    public void updateWork(long id) {
        Query query = getEntityManager().createQuery("update Job j set j.control=:cont where j.Id=:id");
        query.setParameter("id", id);
        query.setParameter("cont", 1);
        query.executeUpdate();

//        Job job = getEntityManager().find(Job.class,id);
//        job.setControl(1);
//        getEntityManager().merge()

    }

    @Transactional
    @Override
    public List<Job> findWork() {
        List<Job> results = getEntityManager().createQuery("SELECT c FROM Job c where c.control=0", Job.class).getResultList();
        return results;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
