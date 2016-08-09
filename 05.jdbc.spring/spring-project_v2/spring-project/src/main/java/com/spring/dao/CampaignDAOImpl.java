package com.spring.dao;

import com.spring.model.Campaign;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        Object[] inputs = new Object[]{
                sequenceValue,
                sequenceValue,
                campaign.getStartDate(),
                campaign.getEndDate(),
                campaign.getCountControl(),
                campaign.getCampaignOption(),
                campaign.getType(),
                campaign.getCampaignName(),
                campaign.getDescription(),
                campaign.getCreationDate(),
                campaign.getModificationDate(),
                campaign.getVersion()};

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
        Object[] inputs = new Object[]{
                campaign.getStartDate(),
                campaign.getEndDate(),
                campaign.getCountControl(),
                campaign.getCampaignOption(),
                campaign.getType(),
                campaign.getCampaignName(),
                campaign.getDescription(),
                campaign.getCreationDate(),
                campaign.getModificationDate(),
                campaign.getVersion(),
                campaignID};

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

                return campaign;
            }
        });

        System.out.println(campaignList);
        return campaignList;
    }
}
