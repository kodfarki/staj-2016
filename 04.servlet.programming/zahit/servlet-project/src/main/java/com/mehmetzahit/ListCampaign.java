package com.mehmetzahit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GUNEY on 3.08.2016.
 */
public class ListCampaign extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List a=select();
        request.setAttribute("allCamp",a);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Campaign.jsp");

        dispatcher.forward(request,response);
    }

    public List<Campaign> select() {
       List<Campaign> campaigns = new LinkedList<Campaign>();

        try {
            Statement statement = JDBCUtil.getConnection().createStatement();
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
