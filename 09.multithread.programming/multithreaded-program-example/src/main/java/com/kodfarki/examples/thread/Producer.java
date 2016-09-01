package com.kodfarki.examples.thread;

import com.kodfarki.examples.model.Job;

import java.util.Date;

public class Producer extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Producer.run");
            com.kodfarki.examples.thread.DataStore.getInstance().produce(new Job(1, new Date(), new Date()));

            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
