package com.spring.zahit.persistence.hibernate.dao;


import com.spring.zahit.model.Campaign;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampaignDAOImpl implements CampaignDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Campaign> findAll() {

/*
Open Sessin kullanımı bu şekildedir.Ayrıca getCurrent Session için Transaction kullanılmaktadır.
        List<Campaign> query = sessionFactory.openSession().createQuery("SELECT  c FROM Campaign c").list();
        return query;
*/

        List<Campaign> query = sessionFactory.getCurrentSession().createQuery("SELECT  c FROM Campaign c").list();
// or using them
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Campaign.class);


        //TypedQuery türünde kullanılsaydı farkı nedir öğren ?????
        return criteria.list();


    }

    @Override
    public void insert(Campaign campaign) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(campaign);

    }

    @Override
    public void update(Campaign campaign) {
        Session session = sessionFactory.getCurrentSession();
        session.update(campaign);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Campaign campaign = session.get(Campaign.class, id);
        session.delete(campaign);
    }

    @Override
    public Campaign getCampaignById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Campaign campaign = session.get(Campaign.class, id);
        return campaign;
    }
}
