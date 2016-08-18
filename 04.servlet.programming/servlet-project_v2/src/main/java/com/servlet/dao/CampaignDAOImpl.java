package com.servlet.dao;


import com.servlet.helper.ParseHelper;
import com.servlet.model.Campaign;
import com.servlet.util.JDBCUtil;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {

    @Override
    public void insert(Campaign campaign) {
        String query = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQ_SLCM_DEFAULT.NEXTVAL,?,?,?,?,?,?,?,?,?,?,2)";

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1, campaign.getExternalCampaignID());
            preparedStatement.setDate(2, ParseHelper.convertToSQLDate(campaign.getStartDate()));
            preparedStatement.setDate(3, ParseHelper.convertToSQLDate(campaign.getEndDate()));
            preparedStatement.setInt(4, campaign.getCountControl());
            preparedStatement.setInt(5, campaign.getCampaignOption());
            preparedStatement.setInt(6, campaign.getType());
            preparedStatement.setString(7, campaign.getCampaignName());
            preparedStatement.setString(8, campaign.getDescription());
            preparedStatement.setDate(9, new java.sql.Date(new Date().getTime()));
            preparedStatement.setDate(10, new java.sql.Date(new Date().getTime()));

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Inserted the Campaign Object successfully!");
            } else {
                System.out.println("Failed on inserting this object ..");
            }

            preparedStatement.close();

        } catch (Exception exception){
            exception.printStackTrace();
        }

    }

    @Override
    public void update(Campaign campaign) {
        String query = "UPDATE SLCM_CAMPAIGN SET EXTERNAL_CAMPAIGN_ID = ?,START_DATE = ?, END_DATE= ?, COUNT_CONTROL= ?, CAMPAIGN_OPTION= ?, SLCM_CAMPAIGN.TYPE=? , CAMPAIGN_NAME= ?, DESCRIPTION= ?, VERSION= ? WHERE CAMPAIGN_ID= ?";

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1, campaign.getExternalCampaignID());
            preparedStatement.setDate(2, ParseHelper.convertToSQLDate(campaign.getStartDate()));
            preparedStatement.setDate(3, ParseHelper.convertToSQLDate(campaign.getEndDate()));
            preparedStatement.setInt(4, campaign.getCountControl());
            preparedStatement.setInt(5, campaign.getCampaignOption());
            preparedStatement.setInt(6, campaign.getType());
            preparedStatement.setString(7, campaign.getCampaignName());
            preparedStatement.setString(8, campaign.getDescription());
            preparedStatement.setInt(9, campaign.getVersion());
            preparedStatement.setInt(10, campaign.getCampaignID());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Updated the Campaign Object successfully!");
            } else {
                System.out.println("Failed on updating this object ..");
            }

            preparedStatement.close();

        } catch (Exception exception){
            exception.printStackTrace();
        }

    }

    @Override
    public void delete(int campaignID) {
        String query = "DELETE FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID=?";

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,campaignID);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Deleted the Campaign Object successfully!");

            } else {
                System.out.println("Failed on deleting this object ..");
            }

            preparedStatement.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Campaign> select() {
        String query = "SELECT * FROM SLCM_CAMPAIGN";
        List<Campaign> campaignList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Campaign campaign = new Campaign();

                campaign.setCampaignID(resultSet.getInt(1));
                campaign.setExternalCampaignID(resultSet.getString(2));
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

            preparedStatement.close();
            resultSet.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

       return campaignList;
    }
    @Override
    public Campaign selectByID(int campaignID){
        String query = "SELECT * FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID = ?";
        Campaign campaign = new Campaign();

        try{
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, campaignID);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                campaign.setCampaignID(resultSet.getInt(1));
                campaign.setExternalCampaignID(resultSet.getString(2));
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
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        System.out.println(campaign);
        return campaign;
    }

}
