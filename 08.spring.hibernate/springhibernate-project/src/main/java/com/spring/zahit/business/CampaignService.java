package com.spring.zahit.business;

import com.spring.zahit.model.Campaign;

import java.util.List;

/**
 * Created by GUNEY on 22.08.2016.
 */
public interface CampaignService {
    public List<Campaign> findAll();
    public void insert(Campaign campaign);
    public void update(Campaign campaign);
    public void delete(long id);
    public Campaign getCampaignById(long id);
}
