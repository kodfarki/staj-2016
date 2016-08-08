package com.spring.zahit.dao;

import com.spring.zahit.model.Campaign;

import java.util.List;

/**
 * Created by GUNEY on 8.08.2016.
 */
public interface CampaignDAO {
    public void insert(Campaign campaign);
    public void update(Campaign campaign);
    public List<Campaign> campaigns();
}
