package com.mehmetzahit.DAO;

import com.mehmetzahit.model.Campaign;

import java.util.List;

/**
 * Created by GUNEY on 29.07.2016.
 */
public interface CampaignDAO {
    public void insert(Campaign campaign);
    public void update(Campaign campaign);
    public List<Campaign> select();
}
