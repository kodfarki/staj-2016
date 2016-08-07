package com.mustafasarac.query;

import com.mustafasarac.model.Campaign;

import java.util.List;

/**
 * Created by mustafasarac on 31.07.2016.
 */

public interface Query {
    public void insert(Campaign campaign);
    public void update(Campaign campaign);
    public void delete(Campaign campaign);
    public List<Campaign> select();
    public void close();
}
