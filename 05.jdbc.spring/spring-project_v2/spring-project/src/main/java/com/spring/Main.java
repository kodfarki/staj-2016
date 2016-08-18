package com.spring;

import com.spring.dao.CampaignDAO;
import com.spring.dao.CampaignDAOImpl;
import com.spring.model.Campaign;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by mustafasarac on 5.08.2016.
 */


public class Main {

    public static void main(String[] args) {
        System.out.println("\nJDBCProject has started ...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Getting Spring Bean and Database Connection
        CampaignDAO campaignDAO = (CampaignDAOImpl) context.getBean("campaign");

        // Campaign Object Creation
        // 1000 which represents the CampaignID and ExternalCampaignId is just for
        // filling the field in Construction. When it is inserting into the Database Table,
        // it gets a value from the Database Sequence.
        Campaign campaign = new Campaign(new Date(), new Date(), 1, 2, 1, "Campaign_One", "First Campaign in Database Table", new Date(), new Date(), 1);

        // INSERT: inserting this Campaign Object into the table
        campaignDAO.insert(campaign);

        // UPDATE: inserting again the same object but for this one, its values will be updated
        campaignDAO.insert(campaign);

        campaign.setCampaignName("Campaign_2");
        campaign.setDescription("Second campaign in Database Table");
        campaign.setCountControl(2);
        campaign.setCampaignOption(1);
        campaign.setType(2);
        campaignDAO.update(campaign, 1060);

        // READ: reading these objects from Database Table
        campaignDAO.select();

        // DELETE: deleting the object from Database Table
        campaignDAO.delete(1040);
    }
}
