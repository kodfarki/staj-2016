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
        Query query = getEntityManager().createQuery("update Job j set j.status=:stat where j.id=:id");
        query.setParameter("id", id);
        query.setParameter("stat", 1);
        query.executeUpdate();
    }

    @Transactional
    @Override
    public List<Job> findWork() {
        List<Job> results = getEntityManager().createQuery("SELECT j FROM Job j where j.status = 0", Job.class).getResultList();
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
