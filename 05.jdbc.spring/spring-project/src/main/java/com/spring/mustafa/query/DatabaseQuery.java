package com.spring.mustafa.query;

import com.spring.mustafa.model.Campaign;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafasarac on 08/08/16.
 */


public class DatabaseQuery implements Query {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Campaign object and a Collection that stores Campaign objects
    protected static List<Campaign> campaignList;
    private static Connection connection;

    //  Getting the database connection
    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                System.out.println("\nConnected database successfully...");
            }
            } catch(SQLException exception){
                exception.printStackTrace();
                System.out.println("\nFailed database connection...");
            }
        return connection;
    }

    //  Inserting into the Database table
    public void insert(Campaign campaign) {
        System.out.println("\nDatabaseQuery.insert");

        try {
            String sqlInsertQuery = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQ_SLCM_DEFAULT.NEXTVAL,SEQ_SLCM_DEFAULT.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertQuery);

            preparedStatement.setDate(1, campaign.getStartDate());
            preparedStatement.setDate(2, campaign.getEndDate());
            preparedStatement.setInt(3, campaign.getCountControl());
            preparedStatement.setInt(4, campaign.getCampaignOption());
            preparedStatement.setInt(5, campaign.getType());
            preparedStatement.setString(6, campaign.getCampaignName());
            preparedStatement.setString(7, campaign.getDescription());
            preparedStatement.setTimestamp(8, campaign.getCreationDate());
            preparedStatement.setTimestamp(9, campaign.getModificationDate());
            preparedStatement.setInt(10, campaign.getVersion());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Inserted the Campaign Object successfully!");
            } else {
                System.out.println("Failed on inserting this object ..");
            }

            preparedStatement.close();

            String sqlQuery = "SELECT CAMPAIGN_ID FROM SLCM_CAMPAIGN";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                campaign.setCampaignID(resultSet.getInt(1));
                campaign.setExternalCampaignID(resultSet.getInt(1));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException exception) {
            // log the exception
            exception.printStackTrace();
        }
    }

    // Updating data from the Database table
    public void update(Campaign campaign) {
        System.out.println("\nDatabaseQuery.update");

        try {
            String sqlQuery = "UPDATE SLCM_CAMPAIGN SET START_DATE = ?, END_DATE= ?, COUNT_CONTROL= ?, CAMPAIGN_OPTION= ?, SLCM_CAMPAIGN.TYPE=? , CAMPAIGN_NAME= ?, DESCRIPTION= ?, CREATION_DATE= ?, MODIFICATION_DATE= ?, VERSION= ? WHERE CAMPAIGN_ID= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // setting parameters
            preparedStatement.setDate(1, campaign.getStartDate());
            preparedStatement.setDate(2, campaign.getEndDate());
            preparedStatement.setInt(3, campaign.getCountControl());
            preparedStatement.setInt(4, campaign.getCampaignOption());
            preparedStatement.setInt(5, campaign.getType());
            preparedStatement.setString(6, campaign.getCampaignName());
            preparedStatement.setString(7, campaign.getDescription());
            preparedStatement.setTimestamp(8, campaign.getCreationDate());
            preparedStatement.setTimestamp(9, campaign.getModificationDate());
            preparedStatement.setInt(10, campaign.getVersion());
            preparedStatement.setInt(11, campaign.getCampaignID());

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
    public void delete(Campaign campaign) {
        System.out.println("\nDatabaseQuery.delete");

        try {
            String sqlQuery = "DELETE FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, campaign.getCampaignID());

            for (int i = 0; i < campaignList.size(); i++) {
                if (campaignList.get(i).getCampaignID() == campaign.getCampaignID()) {
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

        } catch (SQLException exception) {
            // log the exception
            exception.printStackTrace();
        }
    }

    //  Reading data from the Database table
    public List<Campaign> select() {
        System.out.println("\nDatabaseQuery.select");

        campaignList = new LinkedList<Campaign>();

        try{
            // inserting this Campaign Object to List<Campaign>
            String sqlQuery = "SELECT * FROM SLCM_CAMPAIGN";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Campaign myCampaign;

                int myCampaignID = resultSet.getInt(1);
                int myExternalCampaignID = resultSet.getInt(2);
                java.sql.Date myStartDate = resultSet.getDate(3);
                java.sql.Date myEndDate = resultSet.getDate(4);
                int myCountControl = resultSet.getInt(5);
                int myCampaignOption = resultSet.getInt(6);
                int myType = resultSet.getInt(7);
                String myCampaignName = resultSet.getString(8);
                String myDescription = resultSet.getString(9);
                Timestamp myCreationDate = resultSet.getTimestamp(10);
                Timestamp myModificationDate = resultSet.getTimestamp(11);
                int myVersion = resultSet.getInt(12);

                myCampaign = new Campaign(myCampaignID, myExternalCampaignID, myStartDate, myEndDate, myCountControl, myCampaignOption, myType, myCampaignName, myDescription, myCreationDate, myModificationDate, myVersion);

                campaignList.add(myCampaign);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException exception){
            exception.printStackTrace();
        }

        System.out.println(campaignList);
        return campaignList;
    }

    //  Closing the database connection
    public void close() {
        try {
            connection.close();
            System.out.println("\nConnection closed ...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Converting String to sql.DATE Format
    public java.sql.Date getDate(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        java.sql.Date startDate;

        try {
            parsedDate = simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startDate = new java.sql.Date(parsedDate.getTime());

        return startDate;
    }

    // Converting String to sql.Timestamp Format
    public java.sql.Timestamp getTimestamp(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        Date parsedDate = null;
        java.sql.Timestamp timestamp;

        try {
            parsedDate = simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return timestamp;
    }

}
