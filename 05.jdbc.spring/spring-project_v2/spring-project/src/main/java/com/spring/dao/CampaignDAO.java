package com.spring.dao;

import com.spring.model.Campaign;

import java.util.List;

/**
 * Created by mustafasarac on 08/08/16.
 */

public interface CampaignDAO {
     void insert(Campaign campaign);
     void update(Campaign campaign, int campaignID);
     void delete(int campaignID);
     List<Campaign> select();
}
