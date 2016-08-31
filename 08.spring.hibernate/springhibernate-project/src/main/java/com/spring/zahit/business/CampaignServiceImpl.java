package com.spring.zahit.business;

import com.spring.zahit.persistence.hibernate.dao.CampaignDAOImpl;
import com.spring.zahit.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GUNEY on 22.08.2016.
 */
@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignDAOImpl campaignDAOImpl;

    @Transactional
    @Override
    public List<Campaign> findAll() {
        return campaignDAOImpl.findAll();
    }

    @Transactional
    @Override
    public void insert(Campaign campaign) {
        campaignDAOImpl.insert(campaign);
    }

    @Transactional
    @Override
    public void update(Campaign campaign) {
        campaignDAOImpl.update(campaign);
    }

    @Transactional
    @Override
    public void delete(long id) {
        campaignDAOImpl.delete(id);

    }

    @Transactional
    @Override
    public Campaign getCampaignById(long id) {
        return campaignDAOImpl.getCampaignById(id);
    }
}
