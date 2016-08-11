package org.hibernate.mustafa;

import org.hibernate.mustafa.dao.CampaignDAOImpl;
import org.hibernate.mustafa.model.Campaign;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Campaign campaign = new Campaign(new Date(), new Date(), 1, 2, 1, "Campaign_1", "First Campaign in Database Table", new Date(), new Date(), 1);
        CampaignDAOImpl campaignDAO = new CampaignDAOImpl();

        // INSERTION
        campaignDAO.insert(campaign);

        // UPDATE
        campaign.setDescription("UPDATED CAMPAIGN");
        campaign.setCampaignName("Campaign_UPDATED");
        campaignDAO.update(campaign, 1002);

        // READ
        campaignDAO.select();

        // DELETE
        campaignDAO.delete(1001);
    }
}
