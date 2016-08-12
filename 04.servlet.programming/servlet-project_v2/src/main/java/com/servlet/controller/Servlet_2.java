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


@WebServlet(name = "campaignServlet", urlPatterns = {"/campaignServlet"})
public class Servlet_2 extends HttpServlet {

    private CampaignDAOImpl campaignDAO;
    private static String LIST_CAMPAIGN = "/campaigns.jsp";
    private static String INSERT_OR_EDIT = "CampaignForm.jsp";

    public Servlet_2(){
        super();
        campaignDAO = new CampaignDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        String forward = "";
        String action = request.getParameter("action");

        if(action.equalsIgnoreCase("delete")) {
            int campaignID = Integer.parseInt(request.getParameter("campaignId"));
            campaignDAO.delete(campaignID);
            forward = LIST_CAMPAIGN;
            request.setAttribute("campainList", campaignDAO.select());
        } else if (action.equalsIgnoreCase("update")){
            forward = INSERT_OR_EDIT;
            int campaignID = Integer.parseInt(request.getParameter("campaignId"));
            Campaign campaign = campaignDAO.selectByID(campaignID);
            campaignDAO.update(campaign, campaignID);
            request.setAttribute("campaign", campaign);
        } else if (action.equalsIgnoreCase("select")){
            forward = LIST_CAMPAIGN;
            request.setAttribute("users", campaignDAO.select());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Campaign campaign = new Campaign();

        // The fields for data that is requested from 'CampaignForm.jsp'

        campaign.setCampaignName(request.getParameter("name"));
        campaign.setType(Character.getNumericValue(request.getParameter("type").charAt(0)));
        campaign.setCampaignOption(Character.getNumericValue(request.getParameter("countOption").charAt(0)));
        campaign.setDescription(request.getParameter("description"));

        int externalCampaignID = 0;
        if(ParseHelper.isInteger(request.getParameter("externalCampaignId"))){
            externalCampaignID = Integer.parseInt(request.getParameter("externalCampaignId"));
        }
        campaign.setExternalCampaignID(externalCampaignID);

        int countControl = 0;
        if(ParseHelper.isInteger(request.getParameter("countControl"))) {
            countControl = Integer.parseInt(request.getParameter("countControl"));
        }
        campaign.setCountControl(countControl);

        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        java.sql.Date startDate = ParseHelper.parseDate(startDateStr);
        java.sql.Date endDate = ParseHelper.parseDate(endDateStr);

        campaign.setStartDate(startDate);
        campaign.setEndDate(endDate);

        String campaignID = request.getParameter("campaignId");

        if(campaignID == null || campaignID.isEmpty()){
            campaignDAO.insert(campaign);
        } else {
            campaignDAO.update(campaign, Integer.parseInt(campaignID));
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_CAMPAIGN);
        request.setAttribute("campaignList", campaignDAO.select());
        view.forward(request, response);
    }

}
