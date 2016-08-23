package com.spring.zahit.persistence.jpa.dao;

import com.spring.zahit.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by GUNEY on 22.08.2016.
 */
@Repository
public class CampaignDAOImpll implements CampaignDAO {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Campaign> findAll() {

        return null;
    }

    @Override
    public void insert(Campaign campaign) {
        entityManager.persist(campaign);

    }

    @Override
    public void update(Campaign campaign) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Campaign getCampaignById(long id) {
        return null;
    }
}
