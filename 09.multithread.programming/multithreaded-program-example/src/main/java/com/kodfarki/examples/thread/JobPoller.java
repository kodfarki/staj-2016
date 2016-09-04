package com.kodfarki.examples.thread;

import com.kodfarki.examples.model.Job;

import java.util.concurrent.BlockingQueue;


public class JobPoller extends Thread {

    private BlockingQueue<Job> queue;

    public JobPoller(BlockingQueue<Job> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("JobPoller.run");
            for(Job job: DataStore.getInstance().work()){
                queue.offer(job);
                DataStore.getInstance().updateProcess(job.getId());
            }
            sleep();
        }
    }

    /** Thread önceliği kuralına göre Thread.sleep sürelerini
     *  bütün Thread classları için aynı yaptım. Aksi takdirde
     *  önceliği olan thread sürekli çalışmaya başlayıp diğer
     *  threadi etkiliyordu. */

    private void sleep() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
