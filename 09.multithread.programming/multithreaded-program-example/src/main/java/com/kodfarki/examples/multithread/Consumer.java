package com.kodfarki.examples.multithread;

/**
 * User: Halil Karakose
 * Date: 31/08/16
 * Time: 16:31
 */
public class Consumer extends Thread{
    @Override
    public void run() {

        while (true) {


            x();

        }
    }

    private synchronized void x() {
        String consumed = DataStore.getInstance().consume();
        System.out.println(Thread.currentThread().getName() + " consumed: " + consumed);

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
