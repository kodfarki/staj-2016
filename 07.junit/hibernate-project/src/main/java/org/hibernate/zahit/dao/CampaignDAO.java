package org.hibernate.zahit.dao;



import org.hibernate.zahit.model.Campaign;

import java.util.List;

/**
 * Created by GUNEY on 8.08.2016.
 */
public interface CampaignDAO {
    public int insert(Campaign campaign);
    public void update(long id,Campaign campaign);
    public void update2(long id,Campaign campaign);
    public List<Campaign> read();
    public int delete(long campaignID);

}
