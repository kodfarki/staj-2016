package com.mustafasarac.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafasarac on 3.08.2016.
 */

public class DatabaseQuery {

    // SQL Statement
    protected static PreparedStatement preparedStatement;

    // Campaign object and a Collection that stores Campaign objects
    protected static Campaign campaign;
    protected static List<Campaign> campaignList = new ArrayList<Campaign>(20);

    //  Inserting into the Database table
    protected  static void insert(String insertQuery) throws SQLException {
        System.out.println("\nDatabaseQuery.insert");
        try {
            String sqlInsertQuery = "INSERT INTO SLCM_CAMPAIGN " + insertQuery;

            preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlInsertQuery);
            preparedStatement.executeUpdate();

            String sqlQuery = "SELECT * FROM SLCM_CAMPAIGN";
            preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery(sqlQuery);
            if(resultSet.next()) {
                int myCampaignID = resultSet.getInt(1);
                int myExternalCampaignID = resultSet.getInt(2);
                Date myStartDate = resultSet.getDate(3);
                Date myEndDate = resultSet.getDate(4);
                int myCountControl = resultSet.getInt(5);
                int myCampaignOption = resultSet.getInt(6);
                int myType = resultSet.getInt(7);
                String myCampaignName = resultSet.getString(8);
                String myDescription = resultSet.getString(9);
                Timestamp myCreationDate = resultSet.getTimestamp(10);
                Timestamp myModificationDate = resultSet.getTimestamp(11);
                int myVersion = resultSet.getInt(12);

                campaign = new Campaign(myCampaignID, myExternalCampaignID, myStartDate,
                        myEndDate, myCountControl, myCampaignOption, myType, myCampaignName,
                        myDescription, myCreationDate, myModificationDate, myVersion);
                campaignList.add(campaign);
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            // log the exception
            throw sqlException;
        }
    }

    // Updating data from the Database table
    protected  static void update() throws SQLException {
        System.out.println("\nDatabaseQuery.update");
        try {
            String sqlQuery = "UPDATE SLCM_CAMPAIGN SET CAMPAIGN_ID = CAMPAIGN_ID_INCREMENT.NEXTVAL, EXTERNAL_CAMPAIGN_ID = EXTERNAL_CAMPAIGN_ID_INCREMENT.NEXTVAL, START_DATE = ?, END_DATE = ?, COUNT_CONTROL = ?, CAMPAIGN_OPTION = ?, TYPE = ?, CAMPAIGN_NAME = ?, DESCRIPTION = ?, CREATION_DATE = ?, MODIFICATION_DATE = ?, VERSION = ?";
            preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);

            // set the preparedstatement parameters
            preparedStatement.setDate(1, Campaign.getStartDate());
            preparedStatement.setDate(2, Campaign.getEndDate());
            preparedStatement.setInt(3, Campaign.getCountControl());
            preparedStatement.setInt(4, Campaign.getCampaignOption());
            preparedStatement.setInt(5, Campaign.getType());
            preparedStatement.setString(6, Campaign.getCampaignName());
            preparedStatement.setString(7, Campaign.getDescription());
            preparedStatement.setTimestamp(8, Campaign.getCreationDate());
            preparedStatement.setTimestamp(9, Campaign.getModificationDate());
            preparedStatement.setInt(10, Campaign.getVersion());

            // call executeUpdate to execute our sql update statement
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            // log the exception
            throw sqlException;
        }
    }

    //  Deleting a row of data with specified campaignID from the Database table
    protected  static void delete(int campaignID) throws SQLException {
        System.out.println("\nDatabaseQuery.delete");
        try {
            String sqlQuery = "DELETE FROM SLCM_CAMPAIGN " + "WHERE CAMPAIGN_ID = " + campaignID;
            preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);

            for(int i=0; i<campaignList.size(); i++){
                if(campaignList.get(i).getCampaignID() == campaignID){
                    campaignList.remove(campaignList.get(i));
                }
            }

            // call executeUpdate to execute our sql update statement
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            // log the exception
            throw sqlException;
        }
    }

    //  Reading data from the Database table
    protected static void select() throws SQLException {
        System.out.println("\nDatabaseQuery.select");
        try {
            String sqlQuery = "SELECT * FROM SLCM_CAMPAIGN";
            preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);

            for(int i=0; i<campaignList.size(); i++)
                System.out.println(campaignList.get(i).toString());

            // call executeUpdate to execute our sql update statement
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            // log the exception
            throw sqlException;
        }
    }

    //  Closing the database connection
    protected static void close() throws SQLException {
        DatabaseConnection.closeConnection();
        System.out.println("Connection closed ...");
    }


}
