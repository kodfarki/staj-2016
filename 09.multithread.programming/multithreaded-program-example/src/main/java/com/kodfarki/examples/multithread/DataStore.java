package com.kodfarki.examples.multithread;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Halil Karakose
 * Date: 31/08/16
 * Time: 16:46
 */
public class DataStore {
    List<String> jobs = new ArrayList<String>();

    public String consume(){
        String job = jobs.get(0);
        return job;
    }

    public void produce(String job) {
        jobs.add(job);
    }

    private DataStore() {
    }

    private static DataStore me;
    public static DataStore getInstance(){
        if (me == null) {
            me = new DataStore();
        }

        return me;
    }
}
