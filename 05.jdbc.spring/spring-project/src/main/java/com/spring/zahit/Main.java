package com.spring.zahit;

import com.spring.zahit.dao.CampaignDAOImpl;
import com.spring.zahit.model.Campaign;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GUNEY on 8.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-zahit.xml");
        Campaign campaign1 = new Campaign();

        com.spring.mustafa.dao.CampaignDAOImpl time = new com.spring.mustafa.dao.CampaignDAOImpl();

        campaign1.setStartDate(time.getDate("2010-08-01"));
        campaign1.setEndDate(time.getDate("2010-08-01"));
        campaign1.setCountControl(6);
        campaign1.setCampaignOption(5);
        campaign1.setType(6);
        campaign1.setCampaignName("Turkcell yaz kampanyası 5gb 10tl");
        campaign1.setDescription("ogrenciye bedava");
        campaign1.setModificationDate(time.getTimestamp("2010-08-01 23:10:20.111"));
        campaign1.setCreationDate(time.getTimestamp("2010-08-01 23:10:20.111"));
        campaign1.setVersion(4);


        CampaignDAOImpl campaignDAOImpl = (CampaignDAOImpl) context.getBean("connection");
        campaignDAOImpl.insert(campaign1);

        //update
        campaignDAOImpl.update(campaign1); //campaignId is required for update


        //Select Query
        for (Campaign campaign : campaignDAOImpl.campaigns()) {
            System.out.println(campaign.getCampaignID());
            System.out.println(campaign.getExternalCampaignID());
            System.out.println(campaign.getStartDate());
            System.out.println(campaign.getEndDate());
            System.out.println(campaign.getCountControl());
            System.out.println(campaign.getCampaignOption());
            System.out.println(campaign.getType());
            System.out.println(campaign.getCampaignName());
            System.out.println(campaign.getDescription());
            System.out.println(campaign.getCreationDate());
            System.out.println(campaign.getModificationDate());
            System.out.println(campaign.getVersion());
            System.out.println("\n\n");
        }

        context.close();
    }
}
