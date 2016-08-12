package com.servlet.controller;

import com.servlet.dao.CampaignDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GUNEY on 12.08.2016.
 */
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CampaignDAOImpl campaignDAOImpl=new CampaignDAOImpl();
        int campaignId=Integer.parseInt(request.getParameter("campaignId"));

        campaignDAOImpl.delete(campaignId);
        response.sendRedirect("campaigns.jsp");
    }

}
