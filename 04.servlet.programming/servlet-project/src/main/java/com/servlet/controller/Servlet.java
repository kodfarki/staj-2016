package com.servlet.controller;

import com.servlet.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mustafasarac on 4.08.2016.
 */

@WebServlet(name = "campaignServlet", urlPatterns = {"/campaignServlet"})
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        // The fields for data that is requested from 'CampaignForm.jsp'
        String campaignName = request.getParameter("name");
        int type = Character.getNumericValue(request.getParameter("type").charAt(0));
        int countOption = Character.getNumericValue(request.getParameter("countOption").charAt(0));
        String description = request.getParameter("description");

        int externalCampaignID = 0;
        if(isInteger(request.getParameter("externalCampaignId"))){
            externalCampaignID = Integer.parseInt(request.getParameter("externalCampaignId"));
        }

        int countControl = 0;
        if(isInteger(request.getParameter("countControl"))) {
            countControl = Integer.parseInt(request.getParameter("countControl"));
        }

        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        Date parsedStart = null, parsedEnd = null;
        java.sql.Date endDate; java.sql.Date startDate;

        try {
            parsedStart = simpleDateFormat.parse(startDateStr);
            parsedEnd = simpleDateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startDate = new java.sql.Date(parsedStart.getTime());

        // endDate is not required to fill in but if the user didn't fill in,
        // it gives a null exception at this point, so i used a if statement.
        if(parsedEnd == null){
            endDate  = null;
        } else {
            endDate = new java.sql.Date(parsedEnd.getTime());
        }


        try {
            // Do not forget to add instructions for Creating these Sequences and SQL Table.
            String insertQuery = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQ_SLCM_DEFAULT.NEXTVAL,?,?,?,?,?,?,?,?,to_date('01.08.2016','dd.MM.yyyy'),to_date('02.08.2016','dd.MM.yyyy'),2)";

            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(insertQuery);
            preparedStatement.setInt(1, externalCampaignID);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);
            preparedStatement.setInt(4, countControl);
            preparedStatement.setInt(5, countOption);
            preparedStatement.setInt(6, type);
            preparedStatement.setString(7, campaignName);
            preparedStatement.setString(8, description);

            preparedStatement.executeQuery();
            response.sendRedirect("campaigns.jsp");
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean isInteger(String string) {
        if (string == null) {
            return false;
        }
        int length = string.length();
        if (length == 0) {
            return false;
        }
        int i=0;
        for (; i < length; i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
