package com.servlet.dao;


import com.servlet.model.Campaign;
import com.servlet.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {


    private List<Campaign> campaignList;

    @Override
    public void insert(Campaign campaign) {
        String query = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQ_SLCM_DEFAULT.NEXTVAL,?,?,?,?,?,?,?,?,to_date('01.08.2016','dd.MM.yyyy'),to_date('02.08.2016','dd.MM.yyyy'),2)";

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, campaign.getExternalCampaignID());
            preparedStatement.setDate(2, new java.sql.Date(campaign.getStartDate().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(campaign.getEndDate().getTime()));
            preparedStatement.setInt(4, campaign.getCountControl());
            preparedStatement.setInt(5, campaign.getCampaignOption());
            preparedStatement.setInt(6, campaign.getType());
            preparedStatement.setString(7, campaign.getCampaignName());
            preparedStatement.setString(8, campaign.getDescription());

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
    public void update(Campaign campaign, int campaignID) {
        String query = "UPDATE SLCM_CAMPAIGN SET START_DATE = ?, END_DATE= ?, COUNT_CONTROL= ?, CAMPAIGN_OPTION= ?, SLCM_CAMPAIGN.TYPE=? , CAMPAIGN_NAME= ?, DESCRIPTION= ?, CREATION_DATE= ?, MODIFICATION_DATE= ?, VERSION= ? WHERE CAMPAIGN_ID= ?";

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setDate(1, new java.sql.Date(campaign.getStartDate().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(campaign.getEndDate().getTime()));
            preparedStatement.setInt(3, campaign.getCountControl());
            preparedStatement.setInt(4, campaign.getCampaignOption());
            preparedStatement.setInt(5, campaign.getType());
            preparedStatement.setString(6, campaign.getCampaignName());
            preparedStatement.setString(7, campaign.getDescription());
            preparedStatement.setTimestamp(8, new java.sql.Timestamp(campaign.getCreationDate().getTime()));
            preparedStatement.setTimestamp(9, new java.sql.Timestamp(campaign.getModificationDate().getTime()));
            preparedStatement.setInt(10, campaign.getVersion());
            preparedStatement.setInt(11, campaignID);

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
        String query = "DELETE  FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID=?";

        try {
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,campaignID);

            for (int i = 0; i < campaignList.size(); i++) {
                if (campaignList.get(i).getCampaignID() == campaignID) {
                    campaignList.remove(campaignList.get(i));
                }
            }

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
        campaignList = new ArrayList<Campaign>();

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

            preparedStatement.close();
            resultSet.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

       return campaignList;
    }

    @Override
    public Campaign selectByID(int campaignID){
        String query = "SELECT * FROM SLCM.CAMPAIGN WHERE CAMPAIGN_ID = ?";

        Campaign campaign = new Campaign();

        try{
            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, campaignID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
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
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return campaign;
    }

    public void close(){
        JDBCUtil.closeConnection();
        System.out.println("\nConnection closed..");
    }
}
