package com.kodfarki.examples.multithread;

/**
 * User: Halil Karakose
 * Date: 31/08/16
 * Time: 16:29
 */
public class Application {
    public static void main(String[] args) {
        Producer producer = new com.kodfarki.examples.multithread.Producer();
        producer.start();

        for (int i=0; i<3;i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        System.out.println("Start called");
    }
}
