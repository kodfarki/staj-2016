package com.mustafasarac;

import com.mustafasarac.dao.CampaignDAO;
import com.mustafasarac.model.Campaign;
import com.mustafasarac.dao.CampaignDAOImpl;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        System.out.println("\nJDBCProject has started ...");

        // Database Connection
        CampaignDAO campaignDAO = new CampaignDAOImpl();

        // Campaign Object Creation
        Campaign campaign = new Campaign(new Date(), new Date(), 1, 2, 1, "Campaign_1", "First Campaign in Database Table", new Date(), new Date(), 1);

        // INSERT: inserting this Campaign Object into the table
        campaignDAO.insert(campaign);

        // UPDATE: inserting again the same object but for this one, its values will be updated
        campaignDAO.insert(campaign);

        campaign.setCampaignName("Campaign_NEW");
        campaign.setDescription("New campaign in Database Table");
        campaignDAO.update(campaign, 1040);

        // READ: reading these objects from Database Table
        campaignDAO.select();

        // DELETE: deleting the object from Database Table
        campaignDAO.delete(1000);

        // Closing Connection
        campaignDAO.closeConnection();
    }
}
