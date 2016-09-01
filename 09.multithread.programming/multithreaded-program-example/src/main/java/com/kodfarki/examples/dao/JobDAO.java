package com.kodfarki.examples.dao;

import com.kodfarki.examples.model.Job;

import java.util.List;

public interface JobDAO {
    void insert(Job job);
    List<Job> findWork();
    void updateWork(long id);
}
