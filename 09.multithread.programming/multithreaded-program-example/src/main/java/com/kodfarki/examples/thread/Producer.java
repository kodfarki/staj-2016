package com.kodfarki.examples.thread;

import com.kodfarki.examples.model.Job;

import java.util.Date;

public class Producer extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Producer.run");
            Job job = new Job(1, new Date(), new Date());
            DataStore.getInstance().produce(job);

            sleep();
        }
    }

    /**
     * Thread önceliği kuralına göre Thread.sleep sürelerini
     * bütün Thread classları için aynı yaptım. Aksi takdirde
     * önceliği olan thread sürekli çalışmaya başlayıp diğer
     * threadi etkiliyordu.
     */

    private void sleep() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
