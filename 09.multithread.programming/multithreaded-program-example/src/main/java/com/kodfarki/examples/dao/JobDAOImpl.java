package com.kodfarki.examples.dao;

import com.kodfarki.examples.model.Job;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JobDAOImpl implements JobDAO {

    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Job job) {
        entityManager.persist(job);
    }

    @Transactional
    @Override
    public Job getJobById(long Id) {
        return getEntityManager().find(Job.class, Id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
