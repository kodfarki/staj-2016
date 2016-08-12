package com.servlet.controller;


import com.servlet.dao.CampaignDAOImpl;
import com.servlet.helper.ParseHelper;
import com.servlet.model.Campaign;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "campaignServlet", urlPatterns = {"/campaignServlet"})
public class CampaignController extends HttpServlet{

    private CampaignDAOImpl campaignDAO;

    public CampaignController(){
        super();
        campaignDAO = new CampaignDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        Campaign campaign = new Campaign();

        // The fields for data that is requested from 'CampaignForm.jsp'
        campaign.setCampaignName(request.getParameter("name"));
        campaign.setExternalCampaignID(ParseHelper.parseInteger(request.getParameter("externalCampaignId")));
        campaign.setStartDate(ParseHelper.parseDate(request.getParameter("startDate")));
        campaign.setType(Character.getNumericValue(request.getParameter("type").charAt(0)));
        campaign.setEndDate(ParseHelper.parseDate(request.getParameter("endDate")));
        campaign.setCountControl(ParseHelper.parseInteger(request.getParameter("countControl")));
        campaign.setCampaignOption(Character.getNumericValue(request.getParameter("countOption").charAt(0)));
        campaign.setDescription(request.getParameter("description"));

        campaignDAO.insert(campaign);
        response.sendRedirect("campaigns.jsp");
    }
}
