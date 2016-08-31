package com.spring.zahit.presentation;

import com.spring.zahit.model.Campaign;
import com.spring.zahit.persistence.jpa.dao.CampaignDAO;
import com.spring.zahit.persistence.jpa.dao.CampaignDAOImpll;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by GUNEY on 22.08.2016.
 */
public class MainJPA {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-jpa.xml");
        CampaignDAO campaignDAO=context.getBean(CampaignDAOImpll.class);



        Campaign campaign = new Campaign();

        campaign.setStartDate(new Date());
        campaign.setEndDate(new Date());
        campaign.setCountControl(6);
        campaign.setCampaignOption(5);
        campaign.setType(6);
        campaign.setCampaignName("53Turkcell hattını taşıyanlara sınırsız internet ");
        campaign.setDescription("ogrenciye bedava");
        campaign.setModificationDate(new Date());
        campaign.setCreationDate(new Date());
        campaign.setVersion(4);

        campaignDAO.insert(campaign);
    }


}
