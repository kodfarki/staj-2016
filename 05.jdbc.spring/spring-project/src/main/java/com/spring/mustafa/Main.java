package com.spring.mustafa;

import com.spring.mustafa.model.Campaign;
import com.spring.mustafa.dao.CampaignDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mustafasarac on 5.08.2016.
 */


public class Main {

    public static void main(String[] args) {
        System.out.println("\nJDBCProject has started ...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-mustafa.xml");

        // Getting Spring Bean and Database Connection
        CampaignDAOImpl campaignDAO = (CampaignDAOImpl) context.getBean("campaign");
        campaignDAO.getConnection();

        // Campaign Object Creation
        // 1000 which represents the CampaignID and ExternalCampaignId is just for
        // filling the field in Construction. When it is inserting into the Database Table,
        // it gets a value from the Database Sequence.
        Campaign campaign = new Campaign(campaignDAO.getDate("2016-08-01"), campaignDAO.getDate("2016-08-01"), 1, 2, 1, "Campaign_1", "First Campaign in Database Table", campaignDAO.getTimestamp("2016-08-01 09:30:15.032"), campaignDAO.getTimestamp("2016-08-02 09:15:21.221"), 1);

        // INSERT: inserting this Campaign Object into the table
        campaignDAO.insert(campaign);

        // UPDATE: inserting again the same object but for this one, its values will be updated
        campaignDAO.insert(campaign);

        campaign.setCampaignName("Campaign_2");
        campaign.setDescription("Second campaign in Database Table");
        campaign.setCountControl(2);
        campaign.setCampaignOption(1);
        campaign.setType(2);
        campaign.setStartDate(campaignDAO.getDate("2016-08-09"));
        campaignDAO.update(campaign, 1001);

        // READ: reading these objects from Database Table
        campaignDAO.select();

        // DELETE: deleting the object from Database Table
        campaignDAO.delete(1000);

        // Closing Connection
        campaignDAO.close();
    }
}
