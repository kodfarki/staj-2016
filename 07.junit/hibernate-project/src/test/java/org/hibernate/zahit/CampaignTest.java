package org.hibernate.zahit;


import org.hibernate.zahit.dao.CampaignDAO;
import org.hibernate.zahit.dao.CampaignDAOImpl;
import org.hibernate.zahit.model.Campaign;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

public class CampaignTest {
    private CampaignDAO campaignDAO;


    @Before
    public void setUp() throws Exception {
        campaignDAO = new CampaignDAOImpl();

    }

    @Test
    public void select() throws Exception {

        List<Campaign> read = campaignDAO.read();

        assertNotNull(read);

    }

    @Test
    public void delete() throws Exception {
        int delete = campaignDAO.delete(1005);
        assertEquals(1, delete);
    }

    @Test
    public void testInsert() throws Exception {
        //GIVEN
        Campaign campaign1 = new Campaign();
        campaign1.setStartDate(new Date());
        campaign1.setEndDate(new Date());
        campaign1.setCountControl(6);
        campaign1.setCampaignOption(5);
        campaign1.setType(6);
        campaign1.setCampaignName("Turkcell hattını taşıyanlara sınırsız internet ");
        campaign1.setDescription("ogrenciye bedava");
        campaign1.setModificationDate(new Date());
        campaign1.setCreationDate(new Date());
        campaign1.setVersion(4);

        //WHEN
        int insert = campaignDAO.insert(campaign1);

        //THEN
        assertEquals(1, insert);

    }



}
