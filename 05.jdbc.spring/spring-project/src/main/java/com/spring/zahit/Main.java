package com.spring.zahit;

import com.spring.zahit.dao.CampaignDAOImpl;
import com.spring.zahit.model.Campaign;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by GUNEY on 8.08.2016.
 */
public class Main {
    public static void main(String[] args) {

        Campaign campaign=new Campaign();
        SimpleDateFormat dt1 = new SimpleDateFormat("2016-08-01");


      //  Campaign campaign = new Campaign(1000, 1000, databaseQuery.getDate("2016-08-01"), databaseQuery.getDate("2016-08-01"), 1, 2, 1, "Campaign_1", "First Campaign in Database Table", databaseQuery.getTimestamp("2016-08-01 09:30:15.032"), databaseQuery.getTimestamp("2016-08-02 09:15:21.221"), 1);

        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("spring-config-zahit.xml");
        CampaignDAOImpl campaignDAOImpl= (CampaignDAOImpl) context.getBean("connection");
        campaignDAOImpl.insert(campaign);

        context.close();
    }
}
