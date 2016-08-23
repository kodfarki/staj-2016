package com.spring.zahit.presentation;


import com.spring.zahit.business.CampaignService;
import com.spring.zahit.business.CampaignServiceImpl;
import com.spring.zahit.model.Campaign;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MainHibernate {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CampaignService campaignService = context.getBean(CampaignServiceImpl.class);


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


        //campaignService.insert(campaign);
        //campaign.setCampaignID(6);
        //campaignService.update(campaign);
        //campaignService.delete(1046);
        //System.out.println(campaignService.getCampaignById(1046));
        System.out.println(campaignService.findAll());
    }
}
