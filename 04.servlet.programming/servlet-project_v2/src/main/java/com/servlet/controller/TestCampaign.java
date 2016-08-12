package com.servlet.controller;

import com.servlet.dao.CampaignDAOImpl;
import com.servlet.model.Campaign;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


/**
 * Created by GUNEY on 11.08.2016.
 */
public class TestCampaign extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            CampaignDAOImpl campaignDAO = new CampaignDAOImpl();
            List<Campaign> products = campaignDAO.select();


            request.setAttribute("user",campaignDAO.select());
            RequestDispatcher view = request.getRequestDispatcher("/test.jsp");
            view.forward(request, response);

    }



}
