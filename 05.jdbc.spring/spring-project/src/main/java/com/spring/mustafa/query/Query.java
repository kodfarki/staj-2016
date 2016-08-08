package com.spring.mustafa.query;

import com.spring.mustafa.model.Campaign;

import java.util.List;

/**
 * Created by mustafasarac on 08/08/16.
 */

public interface Query {
    public void insert(Campaign campaign);
    public void update(Campaign campaign);
    public void delete(Campaign campaign);
    public List<Campaign> select();
    public void close();
}
