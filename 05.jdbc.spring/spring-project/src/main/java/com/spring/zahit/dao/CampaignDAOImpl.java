package com.spring.zahit.dao;

import com.spring.zahit.model.Campaign;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUNEY on 8.08.2016.
 */
public class CampaignDAOImpl implements CampaignDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void insert(Campaign campaign) {

        try {
            Connection connection = dataSource.getConnection();
            String query = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQ_SLCM_DEFAULT.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "1"); //campaign.setExternalCampaignID() foreign key
            preparedStatement.setDate(2, campaign.getStartDate());
            preparedStatement.setDate(3, campaign.getEndDate());
            preparedStatement.setInt(4, campaign.getCountControl());
            preparedStatement.setInt(5, campaign.getCampaignOption());
            preparedStatement.setInt(6, campaign.getType());
            preparedStatement.setString(7, campaign.getCampaignName());
            preparedStatement.setString(8, campaign.getDescription());
            preparedStatement.setTimestamp(9, campaign.getCreationDate());
            preparedStatement.setTimestamp(10, campaign.getModificationDate());
            preparedStatement.setInt(11, campaign.getVersion());


            int i = preparedStatement.executeUpdate();
            if (i > 0) System.out.println("Kayıt Ekleme Başarılı");
            else
                System.out.println("Kayıt Ekleme Başarısız");
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public void update(Campaign campaign) {
        try {
            Connection connection = dataSource.getConnection();
            String query = "UPDATE SLCM_CAMPAIGN SET START_DATE = ?, END_DATE= ?, COUNT_CONTROL= ?, CAMPAIGN_OPTION= ?, SLCM_CAMPAIGN.TYPE=? , CAMPAIGN_NAME= ?, DESCRIPTION= ?, CREATION_DATE= ?, MODIFICATION_DATE= ?, VERSION= ? WHERE CAMPAIGN_ID= ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
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

            preparedStatement.setLong(11,campaign.getCampaignID());


            int i = preparedStatement.executeUpdate();
            if (i > 0) System.out.println("Güncelleme Başarılı");
            else
                System.out.println("Güncelleme Başarısız");
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public List<Campaign> campaigns() {
        List<Campaign> camp = new ArrayList<Campaign>();
        Connection connection = null;
        String query = "SELECT * FROM SLCM_CAMPAIGN";
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Campaign campaign = new Campaign();

                campaign.setStartDate(resultSet.getDate("START_DATE"));
                campaign.setEndDate(resultSet.getDate("END_DATE"));
                campaign.setCountControl(resultSet.getInt("COUNT_CONTROL"));
                campaign.setCampaignOption(resultSet.getInt("CAMPAIGN_OPTION"));
                campaign.setType(resultSet.getInt("TYPE"));
                campaign.setCampaignName(resultSet.getString("CAMPAIGN_NAME"));
                campaign.setDescription(resultSet.getString("DESCRIPTION"));
                campaign.setCreationDate(resultSet.getTimestamp("CREATION_DATE"));
                campaign.setModificationDate(resultSet.getTimestamp("MODIFICATION_DATE"));
                campaign.setVersion(resultSet.getInt("VERSION"));

                camp.add(campaign);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return camp;
    }
}
