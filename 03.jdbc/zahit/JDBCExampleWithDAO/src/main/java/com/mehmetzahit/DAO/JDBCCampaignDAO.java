package com.mehmetzahit.DAO;

import com.mehmetzahit.model.Campaign;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GUNEY on 29.07.2016.
 */
public class JDBCCampaignDAO implements CampaignDAO {
    Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mustafa", "sento");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void insert(Campaign campaign) {
        String query = "INSERT INTO SLCM_CAMPAIGN VALUES (?,'1',to_date('10.10.2016','dd.MM.yyyy'),'',7,5,5,'none','what is this',to_date('10.10.2016','dd.MM.yyyy'),to_date('10.10.2016','dd.MM.yyyy'),5)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,campaign.getCampaignID());
            int i=preparedStatement.executeUpdate();
            if(i>0) System.out.println("Kayıt Ekleme Başarılı");
            System.out.println("Kayıt Ekleme Başarısız");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void update(Campaign campaign) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE SLCM_CAMPAIGN SET DESCRIPTION=? WHERE CAMPAIGN_ID=?");
            preparedStatement.setString(1,campaign.getDescription());
            preparedStatement.setInt(2,campaign.getCampaignID());
            System.out.println(preparedStatement.executeQuery() +"bak hele");
            preparedStatement.executeQuery();
            System.out.println("Güncelleme Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Campaign> select() {
        List<Campaign> campaigns = new LinkedList<Campaign>();
        try {


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SLCM_CAMPAIGN");
            while (resultSet.next()) {
                Campaign campaign = new Campaign();

                campaign.setCampaignID(resultSet.getInt("CAMPAIGN_ID"));
                campaign.setExternalCampaignID(resultSet.getString("EXTERNAL_CAMPAIGN_ID"));
                campaign.setStartDate(resultSet.getString("START_DATE"));
                campaign.setEndDate(resultSet.getString("END_DATE"));
                campaign.setCountControl(resultSet.getInt("COUNT_CONTROL"));
                campaign.setCampaignOption(resultSet.getInt("CAMPAIGN_OPTION"));
                campaign.setType(resultSet.getInt("TYPE"));
                campaign.setCampaignName(resultSet.getString("CAMPAIGN_NAME"));
                campaign.setDescription(resultSet.getString("DESCRIPTION"));
                campaign.setCreationDate(resultSet.getString("CREATION_DATE"));
                campaign.setModificationDate(resultSet.getString("MODIFICATION_DATE"));
                campaign.setVersion(resultSet.getInt("VERSION"));

                campaigns.add(campaign);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(campaigns);
        return campaigns;
    }
}
