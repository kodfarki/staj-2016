package com.kodfarki.examples;

import com.kodfarki.examples.thread.Producer;

public class Main {

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();

        Worker worker = new Worker();
        worker.start();

    }

}
