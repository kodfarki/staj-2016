package com.kodfarki.examples.thread;

import com.kodfarki.examples.dao.JobDAO;
import com.kodfarki.examples.dao.JobDAOImpl;
import com.kodfarki.examples.model.Job;

/**
 * Created by GUNEY on 1.09.2016.
 */
public class Worker extends Thread {
    @Override
    public void run() {

        while(true){

            for(Job job: DataStore.getInstance().work()){
                System.out.println(job.getCreationDate());
                sleep();
                DataStore.getInstance().updateWork(job.getId());
            }



        }

    }

    private void sleep() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
