package com.mustafasarac.dao;

import com.mustafasarac.model.Campaign;
import com.mustafasarac.util.DatabaseConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class CampaignDAOImpl implements CampaignDAO {

    //  Inserting into the Database table
    public void insert(Campaign campaign) {
        System.out.println("\nDatabaseQuery.insert");

        try {
            String sqlInsertQuery = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQ_SLCM_DEFAULT.NEXTVAL,SEQ_SLCM_DEFAULT.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlInsertQuery);

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

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Inserted the Campaign Object successfully!");
            } else {
                System.out.println("Failed on inserting this object ..");
            }

            preparedStatement.close();

        } catch (SQLException exception) {
            // log the exception
            exception.printStackTrace();
        }
    }

    // Updating data from the Database table
    public void update(Campaign campaign, int campaignID) {
        System.out.println("\nDatabaseQuery.update");

        try {
            String sqlQuery = "UPDATE SLCM_CAMPAIGN SET START_DATE = ?, END_DATE= ?, COUNT_CONTROL= ?, CAMPAIGN_OPTION= ?, SLCM_CAMPAIGN.TYPE=? , CAMPAIGN_NAME= ?, DESCRIPTION= ?, CREATION_DATE= ?, MODIFICATION_DATE= ?, VERSION= ? WHERE CAMPAIGN_ID= ?";
            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);

            // setting parameters
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

        } catch (SQLException exception) {
            // log the exception
            exception.printStackTrace();
        }
    }

    //  Deleting a row of data with specified campaignID from the Database table
    public void delete(int campaignID) {
        System.out.println("\nDatabaseQuery.delete");

        try {
            String sqlQuery = "DELETE FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID = ?";
            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, campaignID);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Deleted the Campaign Object successfully!");
            } else {
                System.out.println("Failed on deleting this object ..");
            }

            preparedStatement.close();

        } catch (SQLException exception) {
            // log the exception
            exception.printStackTrace();
        }
    }

    //  Reading data from the Database table
    public List<Campaign> select() {
        System.out.println("\nDatabaseQuery.select");

        List<Campaign> campaignList = new LinkedList<Campaign>();

        try{
            // inserting this Campaign Object to List<Campaign>
            String sqlQuery = "SELECT * FROM SLCM_CAMPAIGN";
            PreparedStatement  statement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Campaign campaign = new Campaign();

                int myCampaignID = resultSet.getInt(1);
                String myExternalCampaignID = resultSet.getString(2);
                Date myStartDate = resultSet.getDate(3);
                Date myEndDate = resultSet.getDate(4);
                int myCountControl = resultSet.getInt(5);
                int myCampaignOption = resultSet.getInt(6);
                int myType = resultSet.getInt(7);
                String myCampaignName = resultSet.getString(8);
                String myDescription = resultSet.getString(9);
                Date myCreationDate = resultSet.getTimestamp(10);
                Date myModificationDate = resultSet.getTimestamp(11);
                int myVersion = resultSet.getInt(12);

                campaign.setCampaignID(myCampaignID);
                campaign.setExternalCampaignID(myExternalCampaignID);
                campaign.setStartDate(myStartDate);
                campaign.setEndDate(myEndDate);
                campaign.setCountControl(myCountControl);
                campaign.setCampaignOption(myCampaignOption);
                campaign.setType(myType);
                campaign.setCampaignName(myCampaignName);
                campaign.setDescription(myDescription);
                campaign.setCreationDate(myCreationDate);
                campaign.setModificationDate(myModificationDate);
                campaign.setVersion(myVersion);

                campaignList.add(campaign);
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }

        System.out.println(campaignList);
        return campaignList;
    }

    //  Closing the database connection
    public void closeConnection() {
        DatabaseConnection.closeConnection();
        System.out.println("\nConnection closed ...");
    }

}
