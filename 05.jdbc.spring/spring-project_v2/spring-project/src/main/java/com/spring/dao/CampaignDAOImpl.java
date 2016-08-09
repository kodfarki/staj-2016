package com.spring.dao;

import com.spring.model.Campaign;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafasarac on 08/08/16.
 */


public class CampaignDAOImpl extends JdbcDaoSupport implements CampaignDAO {

    // Campaign object and a Collection that stores Campaign objects
    protected static List<Campaign> campaignList;

    //  Inserting into the Database table
    public void insert(Campaign campaign) {
        System.out.println("\nDatabaseQuery.insert");

        String sqlStarterQuery = "SELECT SEQ_SLCM_DEFAULT.NEXTVAL FROM dual";
        int sequenceValue = getJdbcTemplate().queryForObject(sqlStarterQuery, Integer.class);

        String sqlInsertQuery = "INSERT INTO SLCM_CAMPAIGN VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] inputs = new Object[]{sequenceValue, sequenceValue, campaign.getStartDate(), campaign.getEndDate(), campaign.getCountControl(), campaign.getCampaignOption(), campaign.getType(), campaign.getCampaignName(), campaign.getDescription(), campaign.getCreationDate(), campaign.getModificationDate(), campaign.getVersion()};

        int i = getJdbcTemplate().update(sqlInsertQuery, inputs);
        if (i > 0) {
            System.out.println("Inserted the Campaign Object successfully!");
        } else {
            System.out.println("Failed on inserting this object ..");
        }

        campaign.setCampaignID(sequenceValue);
        campaign.setExternalCampaignID(sequenceValue);
    }

    // Updating data from the Database table
    public void update(Campaign campaign, int campaignID) {
        System.out.println("\nDatabaseQuery.update");

        String sqlUpdateQuery = "UPDATE SLCM_CAMPAIGN SET START_DATE = ?, END_DATE= ?, COUNT_CONTROL= ?, CAMPAIGN_OPTION= ?, SLCM_CAMPAIGN.TYPE=? , CAMPAIGN_NAME= ?, DESCRIPTION= ?, CREATION_DATE= ?, MODIFICATION_DATE= ?, VERSION= ? WHERE CAMPAIGN_ID= ?";
        Object[] inputs = new Object[]{campaign.getStartDate(), campaign.getEndDate(), campaign.getCountControl(), campaign.getCampaignOption(), campaign.getType(), campaign.getCampaignName(), campaign.getDescription(), campaign.getCreationDate(), campaign.getModificationDate(), campaign.getVersion(), campaignID};

        int i = getJdbcTemplate().update(sqlUpdateQuery, inputs);
        if (i > 0) {
            System.out.println("Updated the Campaign Object successfully!");
        } else {
            System.out.println("Failed on updating this object ..");
        }
    }

    //  Deleting a row of data with specified campaignID from the Database table
    public void delete(int campaignID) {
        System.out.println("\nDatabaseQuery.delete");

        String sqlDeleteQuery = "DELETE FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID = ?";
        Object[] inputs = new Object[]{campaignID};

        for (int i = 0; i < campaignList.size(); i++) {
            if (campaignList.get(i).getCampaignID() == campaignID) {
                campaignList.remove(campaignList.get(i));
            }
        }

        int i = getJdbcTemplate().update(sqlDeleteQuery, inputs);
        if (i > 0) {
            System.out.println("Deleted the Campaign Object successfully!");
        } else {
            System.out.println("Failed on deleting this object ..");
        }
    }

    //  Reading data from the Database table
    public List<Campaign> select() {
        System.out.println("\nDatabaseQuery.select");

        String sqlQuery = "SELECT * FROM SLCM_CAMPAIGN";

        campaignList = new LinkedList<Campaign>();
        campaignList = getJdbcTemplate().query(sqlQuery, new RowMapper<Campaign>() {

            public Campaign mapRow(ResultSet resultSet, int i) throws SQLException {
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

                Campaign campaign = new Campaign(myStartDate, myEndDate, myCountControl, myCampaignOption, myType, myCampaignName, myDescription, myCreationDate, myModificationDate, myVersion);
                campaign.setCampaignID(myCampaignID);
                campaign.setExternalCampaignID(myExternalCampaignID);

                return campaign;
            }
        });

        System.out.println(campaignList);
        return campaignList;
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
