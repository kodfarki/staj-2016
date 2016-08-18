package org.hibernate.mustafa;

import org.hibernate.mustafa.model.Campaign;
import org.hibernate.mustafa.dao.CampaignDAO;
import org.hibernate.mustafa.dao.CampaignDAOImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CampaignDAOTest {

    private CampaignDAO campaignDAO;

    @Before
    public void setUp() {
        campaignDAO = new CampaignDAOImpl();
    }

    @Test
    public void testInsert() {
        Campaign campaign = new Campaign(new Date(), new Date(), 1, 2, 1, "Campaign_1", "First Campaign in Database Table", new Date(), new Date(), 1);

        int initialSize = campaignDAO.select().size();
        Boolean containsResult = false;

        campaignDAO.insert(campaign);

        for (Campaign cmp : campaignDAO.select()) {
            if (cmp.getCampaignID() == campaign.getCampaignID())
                containsResult = true;
        }

        assertEquals(campaignDAO.select().size(), initialSize + 1);
        assertTrue(containsResult);
        assertNotNull(campaign.getCampaignID());
    }

    @Test
    public void testUpdate() {
        Campaign campaign = new Campaign(new Date(), new Date(), 1, 2, 1, "Campaign", "This will be updated", new Date(), new Date(), 1);

        campaignDAO.insert(campaign);

        campaign.setCampaignName("Updated Campaign");
        campaign.setDescription("This campaign object is updated");

        campaignDAO.update(campaign, campaign.getCampaignID());

        Campaign updatedCampaign = campaignDAO.selectById(campaign.getCampaignID());

        assertEquals("Updated Campaign", updatedCampaign.getCampaignName());
        assertEquals("This campaign object is updated", updatedCampaign.getDescription());
    }

    @Test
    public void testDelete() {
        Campaign campaign = new Campaign(new Date(), new Date(), 1, 2, 1, "Campaign", "This will be deleted", new Date(), new Date(), 1);

        campaignDAO.insert(campaign);

        int sizeAfterInsert = campaignDAO.select().size();
        Boolean containsResult = false;

        campaignDAO.delete(campaign.getCampaignID());

        for (Campaign cmp : campaignDAO.select()) {
            if (cmp.getCampaignID() == campaign.getCampaignID())
                containsResult = true;
        }

        assertEquals(campaignDAO.select().size(), sizeAfterInsert - 1);
        assertFalse(containsResult);
    }

    @Test
    public void testSelect() {
        Campaign campaign = new Campaign(new Date(), new Date(), 2, 1, 2, "Campaign", "A Campaign Object", new Date(), new Date(), 1);
        campaign.setCampaignName("Campaign_A");
        campaign.setDescription("Campaign Object");

        campaignDAO.insert(campaign);

        List<Campaign> campaignList = campaignDAO.select();
        Campaign insertedCampaign = campaignList.get(campaignList.size()-1);

        assertEquals("Campaign_A", insertedCampaign.getCampaignName());
        assertEquals("Campaign Object", insertedCampaign.getDescription());
    }

    @Test
    public void testSelectById() {
        Campaign campaign = new Campaign(new Date(), new Date(), 2, 1, 2, "Campaign", "A Campaign Object", new Date(), new Date(), 1);

        campaignDAO.insert(campaign);

        Campaign insertedCampaign = campaignDAO.selectById(campaign.getCampaignID());

        assertEquals(insertedCampaign.getCampaignID(), campaign.getCampaignID());
        assertEquals(insertedCampaign.getExternalCampaignID(), campaign.getExternalCampaignID());
        assertEquals(insertedCampaign.getCountControl(), campaign.getCountControl());
        assertEquals(insertedCampaign.getCampaignOption(), campaign.getCampaignOption());
        assertEquals(insertedCampaign.getType(), campaign.getType());
        assertEquals(insertedCampaign.getCampaignName(), campaign.getCampaignName());
        assertEquals(insertedCampaign.getDescription(), campaign.getDescription());
        assertEquals(insertedCampaign.getVersion(), campaign.getVersion());
    }
}
