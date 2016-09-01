package com.kodfarki.examples.multithread;

/**
 * User: Halil Karakose
 * Date: 31/08/16
 * Time: 16:29
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Start called");

        Producer producer = new Producer();
        producer.start();




    }
}
