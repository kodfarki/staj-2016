package org.hibernate.mustafa.dao;

import org.hibernate.mustafa.model.Campaign;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private List<Campaign> campaignList;

    public void insert(Campaign campaign) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(campaign);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Campaign campaign, int campaignID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        entityManager.close();
    }

    public void delete(int campaignID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Campaign.class, campaignID));
        entityManager.getTransaction().commit();

        for (int i = 0; i < campaignList.size(); i++) {
            if (campaignList.get(i).getCampaignID() == campaignID) {
                campaignList.remove(campaignList.get(i));
            }
        }
        entityManager.close();
    }

    public List<Campaign> select() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Campaign> query = entityManager.createQuery("SELECT campaign FROM Campaign campaign", Campaign.class);
        campaignList = new ArrayList<Campaign>();
        campaignList = query.getResultList();
        System.out.println(campaignList);
        entityManager.close();
        return campaignList;
    }

}
