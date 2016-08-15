package org.hibernate.mustafa.dao;

import org.hibernate.mustafa.model.Campaign;
import org.hibernate.mustafa.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {

    @Override
    public void insert(Campaign campaign) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(campaign);
            entityManager.getTransaction().commit();
            System.out.println("Inserted the Campaign Successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Failed on Inserting the Campaign Successfully");
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Campaign campaign, int campaignID) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            Campaign updatedCampaign = entityManager.find(Campaign.class, campaignID);
            entityManager.getTransaction().begin();

            // Setting the fields
            updatedCampaign.setStartDate(campaign.getStartDate());
            updatedCampaign.setEndDate(campaign.getEndDate());
            updatedCampaign.setCountControl(campaign.getCountControl());
            updatedCampaign.setCampaignOption(campaign.getCampaignOption());
            updatedCampaign.setType(campaign.getType());
            updatedCampaign.setCampaignName(campaign.getCampaignName());
            updatedCampaign.setDescription(campaign.getDescription());
            updatedCampaign.setCreationDate(campaign.getCreationDate());
            updatedCampaign.setModificationDate(campaign.getModificationDate());
            updatedCampaign.setVersion(campaign.getVersion());

            entityManager.getTransaction().commit();
            System.out.println("Updated the Campaign Successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Failed on Updating the Campaign");
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(int campaignID) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Campaign.class, campaignID));
            entityManager.getTransaction().commit();
            System.out.println("Deleted the Campaign Successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Failed on Deleting the Campaign");
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Campaign> select() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Campaign> campaignList = new ArrayList<Campaign>();

        try {
            campaignList = entityManager.createQuery("SELECT campaign FROM Campaign campaign", Campaign.class).getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        System.out.println(campaignList);
        return campaignList;
    }

}
