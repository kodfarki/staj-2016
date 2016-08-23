package org.hibernate.zahit;


import org.hibernate.zahit.dao.CampaignDAOImpl;
import org.hibernate.zahit.model.Campaign;
import org.hibernate.zahit.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;

/**
 * Created by GUNEY on 8.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        CampaignDAOImpl campaignDAO = new CampaignDAOImpl();


        Campaign campaign1 = new Campaign();

        campaign1.setStartDate(new Date());
        campaign1.setEndDate(new Date());
        campaign1.setCountControl(6);
        campaign1.setCampaignOption(5);
        campaign1.setType(6);
        campaign1.setCampaignName("Turkcell hattını taşıyanlara sınırsız internet ");
        campaign1.setDescription("ogrenciye bedava");
        campaign1.setModificationDate(new Date());
        campaign1.setCreationDate(new Date());
        campaign1.setVersion(4);


        // campaignDAO.insert(campaign1);
       // campaignDAO.read();
        // campaignDAO.update(1012,campaign1);

        // campaignDAO.update2(1012,campaign1);
        campaignDAO.delete(1004);


        ;
    }
}
