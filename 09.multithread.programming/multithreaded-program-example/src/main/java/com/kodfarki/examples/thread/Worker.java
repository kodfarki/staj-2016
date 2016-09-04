package com.kodfarki.examples.thread;

import com.kodfarki.examples.model.Job;

import java.util.concurrent.BlockingQueue;

/**
 * Created by GUNEY on 1.09.2016.
 */
public class Worker extends Thread {

    private BlockingQueue<Job> queue;

    public Worker(BlockingQueue<Job> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        /**
         *  Main Classında bahsettiğim gibi Worker Threadindeki queue.poll() metodu
         *  queue'deki kuyrukta bulunan nesneyi get ediyor ve listeden çıkartıyor.
         *  Worker threadi diğer threadlerden önce çalıştığında bizim queuemiz nesne
         *  dolmadan tamamen boşalıyor ve Worker threadi null pointer hatası dönüyor.
         *  Bu hatayı döndüğünde ise thread ölüyor ve artık çalışmaz hale geliyor.
         *  Uygulamada bu aşamada sadece Producer ve JobPoller threadleri çalışır
         *  halde kalıyor.
         *
         *  Bunun çözebilmek için bir tane if case tanımladım.
         *  Bu if case listemizin kuyruğunda eleman var mı diye kontrol ediyor.
         *
         *  Bu kontrolü yaparken ise queue.peek() kullandım çünkü aşağıda tekrar
         *  poll() ederken listemizden iki kere nesne çıkarmış ve hataya düşmüş olacaktık.
         *  queue.peek() listeden çıkarmadan nesneyi get ediyor. poll() ise hem get ediyor
         *  hem çıkartıyor.
         *
         *  Şu anki haliyle Database tablomuzdaki nesnelerin Status'ları 2 oluyor ve yani
         *  Worker Threadimiz düzgün çalışıyor.
         * */
        while (true) {
            if (queue.peek() != null) {
                System.out.println("Worker.run");
                Job job = queue.poll();
                System.out.println(Thread.currentThread().getName() + " " + job.getCreationDate());

                DataStore.getInstance().updateWork(job.getId());
            }
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
