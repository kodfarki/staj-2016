package com.servlet.controller;

import com.servlet.helper.ParseHelper;
import com.servlet.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GUNEY on 5.08.2016.
 */
@WebServlet("/update")
public class Update_2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //selected the campaignId
        int campaignId = Integer.parseInt(request.getParameter("campaignId"));

        // The fields for data that is requested from 'CampaignForm.jsp'
        String campaignName = request.getParameter("name");
        int type =Integer.parseInt(request.getParameter("type"));
        int countOption = Integer.parseInt(request.getParameter("countOption"));
        String description = request.getParameter("description");

        int externalCampaignID = 0;
        if (ParseHelper.isInteger(request.getParameter("externalCampaignId"))) {
            externalCampaignID = Integer.parseInt(request.getParameter("externalCampaignId"));
        }

        int countControl = 0;
        if (ParseHelper.isInteger(request.getParameter("countControl"))) {
            countControl = Integer.parseInt(request.getParameter("countControl"));
        }

        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        Date parsedStart = null, parsedEnd = null;
        java.sql.Date endDate;
        java.sql.Date startDate;

        try {
            parsedStart = simpleDateFormat.parse(startDateStr);
            parsedEnd = simpleDateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startDate = new java.sql.Date(parsedStart.getTime());

        // endDate is not required to fill in but if the user didn't fill in,
        // it gives a null exception at this point, so i used a if statement.
        if (parsedEnd == null) {
            endDate = null;
        } else {
            endDate = new java.sql.Date(parsedEnd.getTime());
        }

        try {
            // Do not forget to add instructions for Creating these Sequences and SQL Table.

            String updateQuery = "UPDATE SLCM_CAMPAIGN SET EXTERNAL_CAMPAIGN_ID=?,START_DATE=?,END_DATE=?,COUNT_CONTROL=?,CAMPAIGN_OPTION=?,TYPE=?,CAMPAIGN_NAME=?,DESCRIPTION=? WHERE CAMPAIGN_ID=?";

            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(updateQuery);
            preparedStatement.setInt(1, externalCampaignID);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);
            preparedStatement.setInt(4, countControl);
            preparedStatement.setInt(5, countOption);
            preparedStatement.setInt(6, type);
            preparedStatement.setString(7, campaignName);
            preparedStatement.setString(8, description);
            preparedStatement.setInt(9, campaignId);

            preparedStatement.executeQuery();
            out.print("Updated successfully");
            response.sendRedirect("campaigns.jsp");
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}

