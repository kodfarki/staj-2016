package com.servlet.controller;


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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

    private CampaignDAOImpl campaignDAO = new CampaignDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        CampaignDAOImpl campaignDAOImpl = new CampaignDAOImpl();
        int campaignId = Integer.parseInt(request.getParameter("campaignId"));

        List<Campaign> c = new ArrayList<>();

        Campaign c1 = campaignDAOImpl.selectByID(campaignId);
        c.add(c1);

        request.setAttribute("camp", c);
        RequestDispatcher view = request.getRequestDispatcher("update.jsp");
        view.forward(request, response);

    }
@Override
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
        campaign.setCampaignID(ParseHelper.parseInteger(request.getParameter("campaignId")));

        campaignDAO.update(campaign);
        response.sendRedirect("campaignServlet");


    }
}
