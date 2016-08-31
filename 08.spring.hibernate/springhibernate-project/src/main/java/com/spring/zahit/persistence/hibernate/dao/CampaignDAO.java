package com.spring.zahit.persistence.hibernate.dao;


import com.spring.zahit.model.Campaign;

import java.util.List;

public interface CampaignDAO {
    public List<Campaign> findAll();
    public void insert(Campaign campaign);
    public void update(Campaign campaign);
    public void delete(long id);
    public Campaign getCampaignById(long id);
}
