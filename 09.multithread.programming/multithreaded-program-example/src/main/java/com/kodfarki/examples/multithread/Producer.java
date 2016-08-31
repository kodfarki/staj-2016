package com.kodfarki.examples.multithread;

import java.util.Random;

/**
 * User: Halil Karakose
 * Date: 31/08/16
 * Time: 16:30
 */
public class Producer extends Thread {

    @Override
    public void run() {
        while (true) {
            String job = new Random().nextInt() + "";
            System.out.println("Produced: " + job);
            DataStore.getInstance().produce(job);

            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
