package com.kodfarki.examples.dao;

import com.kodfarki.examples.model.Job;

public interface JobDAO {
    void insert(Job job);
    Job getJobById(long Id);
}
