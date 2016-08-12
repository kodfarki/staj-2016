package org.hibernate.zahit.dao;


import org.hibernate.zahit.model.Campaign;
import org.hibernate.zahit.util.JPAUtil;


import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUNEY on 8.08.2016.
 */
public class CampaignDAOImpl implements CampaignDAO {

    @Override
    public void insert(Campaign campaign) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(campaign);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        //try catch transaction ile yonetilmeli rollback
    }

    @Override
    public void update(long id, Campaign campaign) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction updateTransaction = em.getTransaction();
        updateTransaction.begin();
        Query query = em.createNamedQuery("update");
        query.setParameter("campaignName", campaign.getCampaignName());
        query.setParameter("description", campaign.getDescription());
        query.setParameter("id", id);

        int updateCount = query.executeUpdate();
        if (updateCount > 0) {
            System.out.println("Updated...");
        }
        updateTransaction.commit();

    }


    @Override
    public List<Campaign> read() {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        List<Campaign> campaignList = em.createNamedQuery("findAll", Campaign.class).getResultList();

        for (Campaign campaign : campaignList) {
            System.out.print(campaign.getCampaignID() + ") ");
            System.out.println(campaign.getDescription());

        }
        //bu for buradamı olmaı yoksa mainden mi çekilmeli ?

        return campaignList;
    }

    @Override
    public void update2(long id, Campaign campaign) {
        // Obje geçirirerek kullanıldığında çalışmıyor

        EntityManager em = JPAUtil.getEmf().createEntityManager();
        Campaign campaign1 = em.find(Campaign.class, id);
        em.getTransaction().begin();

        campaign.setCampaignID(id);
//
//        campaign1.setStartDate(campaign.getStartDate());
//        campaign1.setEndDate(campaign.getEndDate());
//        campaign1.setCountControl(campaign.getCountControl());
//        campaign1.setCampaignOption(campaign.getCampaignOption());
//        campaign1.setType(campaign.getType());
//        campaign1.setCampaignName(campaign.getCampaignName());
//        campaign1.setDescription(campaign.getDescription());
//        campaign1.setModificationDate(campaign.getModificationDate());
//        campaign1.setCreationDate(campaign.getCreationDate());
//        campaign1.setVersion(campaign.getVersion());

        em.persist(campaign);
        em.getTransaction().commit();

        // campaign1.setCampaignName("example"); //runing
        // campaign1=campaign;  // no runing

    }

    @Override
    public void delete(long campaignID) {
        try {
            EntityManager em = JPAUtil.getEmf().createEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(Campaign.class, campaignID));
            em.getTransaction().commit();
            System.out.println("Deleted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could Not Deleted");
        }
    }


}
