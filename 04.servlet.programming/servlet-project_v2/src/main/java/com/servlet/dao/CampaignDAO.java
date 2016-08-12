package com.servlet.dao;


import com.servlet.model.Campaign;

import java.util.List;

public interface CampaignDAO {
    void insert(Campaign campaign);
    void update(Campaign campaign, int campaignID);
    void delete(int campaignID);
    List<Campaign> select();
    Campaign selectByID(int campaignID);
}
