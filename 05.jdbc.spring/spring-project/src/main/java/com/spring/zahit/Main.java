package com.spring.zahit;

import com.spring.zahit.dao.CampaignDAOImpl;
import com.spring.zahit.model.Campaign;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by GUNEY on 8.08.2016.
 */
public class Main {
    public static void main(String[] args) {

        Campaign campaign1 = new Campaign();
        
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-zahit.xml");
        CampaignDAOImpl campaignDAOImpl = (CampaignDAOImpl) context.getBean("connection");

        //campaignDAOImpl.insert(campaign1);


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
