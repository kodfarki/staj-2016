package com.servlet.controller;


import com.servlet.dao.CampaignDAO;
import com.servlet.dao.CampaignDAOImpl;
import com.servlet.helper.ParseHelper;
import com.servlet.model.Campaign;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "campaignServlet", urlPatterns = {"/campaignServlet"})
public class CampaignController extends HttpServlet{

    private CampaignDAO campaignDAO = new CampaignDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");


        List<Campaign> select = campaignDAO.select();
        request.setAttribute("campaigns", select);
        // ctrl +alt +v
        RequestDispatcher view = request.getRequestDispatcher("campaigns.jsp");
        view.forward(request, response);


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Campaign campaign = new Campaign();

        // The fields for data that is requested from 'CampaignForm.jsp'
        campaign.setCampaignName(request.getParameter("name"));
        campaign.setExternalCampaignID(ParseHelper.parseInteger(request.getParameter("externalCampaignId")));
        campaign.setStartDate(ParseHelper.parseDate(request.getParameter("startDate")));
        campaign.setType(Integer.parseInt(request.getParameter("type")));
        campaign.setEndDate(ParseHelper.parseDate(request.getParameter("endDate")));
        campaign.setCountControl(ParseHelper.parseInteger(request.getParameter("countControl")));
        campaign.setCampaignOption(Integer.parseInt(request.getParameter("countOption")));
        campaign.setDescription(request.getParameter("description"));

        campaignDAO.insert(campaign);
        response.sendRedirect("campaignServlet");

    }

}
