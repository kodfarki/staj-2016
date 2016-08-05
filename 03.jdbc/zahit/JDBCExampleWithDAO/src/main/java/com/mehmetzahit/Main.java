package com.mehmetzahit;

import com.mehmetzahit.DAO.JDBCCampaignDAO;
import com.mehmetzahit.model.Campaign;

/**
 * Created by GUNEY on 29.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Campaign campaign=new Campaign();
        JDBCCampaignDAO jdbcCampaignDAO = new JDBCCampaignDAO();
        jdbcCampaignDAO.getConnection();

      //insert
        campaign.setCampaignID(38);
        jdbcCampaignDAO.insert(campaign);

        //update

       // campaign.setCampaignID(53);
       // campaign.setDescription("www.mehmetzahit.com");
        //jdbcCampaignDAO.update(campaign);

        //Read
        jdbcCampaignDAO.select();
    }
}
