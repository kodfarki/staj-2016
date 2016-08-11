package com.servlet.dao;


import com.servlet.model.Campaign;
import com.servlet.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {

    @Override
    public void insert(Campaign campaign) {

    }

    @Override
    public void update(Campaign campaign, int campaignID) {

    }

    @Override
    public void delete(int campaignID) {

    }

    @Override
    public List<Campaign> select() {
        String query = "SELECT * FROM SLCM_CAMPAIGN";
        List<Campaign> campaignList = new ArrayList<Campaign>();

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Campaign campaign = new Campaign();

                campaign.setCampaignID(resultSet.getInt(1));
                campaign.setExternalCampaignID(resultSet.getInt(2));
                campaign.setStartDate(resultSet.getDate(3));
                campaign.setEndDate(resultSet.getDate(4));
                campaign.setCountControl(resultSet.getInt(5));
                campaign.setCampaignOption(resultSet.getInt(6));
                campaign.setType(resultSet.getInt(7));
                campaign.setCampaignName(resultSet.getString(8));
                campaign.setDescription(resultSet.getString(9));
                campaign.setCreationDate(resultSet.getDate(10));
                campaign.setModificationDate(resultSet.getDate(11));
                campaign.setVersion(resultSet.getInt(12));

                campaignList.add(campaign);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

       return campaignList;
    }
}
