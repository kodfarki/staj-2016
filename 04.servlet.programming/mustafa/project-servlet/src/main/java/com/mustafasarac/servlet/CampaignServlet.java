package com.mustafasarac.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by mustafasrac on 3.08.2016.
 */

@WebServlet (name = "campaignServlet", urlPatterns = {"/campaignServlet"})
public class CampaignServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        String campaignName = req.getParameter("name");
        int externalCampaignID = Integer.parseInt(req.getParameter("externalCampaignId"));

        String startDateStr = req.getParameter("startDate");
        String endDateStr = req.getParameter("endDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        Date parsedStart =null, parsedEnd = null;
        try {
            parsedStart = simpleDateFormat.parse(startDateStr);
            parsedEnd = simpleDateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date startDate = new java.sql.Date(parsedStart.getTime());
        java.sql.Date endDate = new java.sql.Date(parsedEnd.getTime());

        int type = Character.getNumericValue(req.getParameter("type").charAt(0));
        int countControl = Integer.parseInt(req.getParameter("countControl"));
        int countOption = Character.getNumericValue(req.getParameter("countOption").charAt(0));
        String description = req.getParameter("description");

        try {
            String insertQuery = "INSERT INTO SLCM_CAMPAIGN VALUES (MUSTAFA.CAMPAIGN_ID_INCREMENT.NEXTVAL,?,?,?,?,?,?,?,?,to_date('01.08.2016','dd.MM.yyyy'),to_date('02.08.2016','dd.MM.yyyy'),2)";

            DatabaseQuery.preparedStatement = DatabaseConnection.getConnection().prepareStatement(insertQuery);
            DatabaseQuery.preparedStatement.setInt(1, externalCampaignID);
            DatabaseQuery.preparedStatement.setDate(2, startDate);
            DatabaseQuery.preparedStatement.setDate(3, endDate);
            DatabaseQuery.preparedStatement.setInt(4, countControl);
            DatabaseQuery.preparedStatement.setInt(5, countOption);
            DatabaseQuery.preparedStatement.setInt(6, type);
            DatabaseQuery.preparedStatement.setString(7, campaignName);
            DatabaseQuery.preparedStatement.setString(8, description);

            DatabaseQuery.preparedStatement.executeQuery();

            String sqlQuery = "SELECT * FROM SLCM_CAMPAIGN WHERE EXTERNAL_CAMPAIGN_ID =" + externalCampaignID;
            DatabaseQuery.preparedStatement = DatabaseConnection.getConnection().prepareStatement(sqlQuery);
            ResultSet resultSet = DatabaseQuery.preparedStatement.executeQuery(sqlQuery);
            if(resultSet.next()) {
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

                DatabaseQuery.campaign = new Campaign(myCampaignID, myExternalCampaignID, myStartDate,
                        myEndDate, myCountControl, myCampaignOption, myType, myCampaignName,
                        myDescription, myCreationDate, myModificationDate, myVersion);
                DatabaseQuery.campaignList.add(DatabaseQuery.campaign);
                DatabaseQuery.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
