package com.kodfarki.examples;

import com.kodfarki.examples.model.Job;
import com.kodfarki.examples.thread.JobPoller;
import com.kodfarki.examples.thread.Producer;
import com.kodfarki.examples.thread.Worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        /**
         *  Cuma günü projeyi yaptığımızda buradaki Worker Threadini bir for loop içerisinde
         *  3 kere çağrılacak şekilde çalıştırmıştık. Fakat Worker'ın implementasyonuna
         *  bakacak olursak bizim queue listemizin kuyruğunda bulunan nesneyi poll() metoduyla
         *  get ediyor ve listeden çıkartıyor. İşte bu noktada Worker threadimiz, 3 kere
         *  çağrıldığında diğer Producer ve JobPoller threadlerinden önce çalışmış oluyordu
         *  ve böylece queue listemize nesne dolamadan, worker bütün nesneleri boşaltıyordu.
         *  Nesneler listeden tamamen boşalınca ise Worker threadi null pointer dönüyor ve thread
         *  ölüyor. Thread ölünce ise artık bizim uygulamamızda Worker threadi çalışmadığından
         *  sadece Producer ve JobPoller çalışarak queue'ye eleman eklemek dışında başka bir şey
         *  yapmaz hale geliyor uygulama.İşte bu yüzden Cuma günü yaptığımızda hiçbir nesnenin
         *  Status'u 2 değil de 1 olmuştu.
         *
         *  Ben bu hatayı birkaç değişiklik yaparak düzelttim. Şuanda queue'deki bütün nesneler
         *  process aşamasından work aşamasına geçiyor ve status 2'e update ediliyor.
         *  Fakat Halil Abinin o gün dediği gibi biz Worker threadinin diğerlerinden fazla
         *  çalışmasını istiyoruz ve böylece orada bir hata yapılmış mı bunu görmek istiyoruz.
         *  Hata yapılmışsa düzeltmek istiyoruz bu yüzden for loop içerisine koyarak daha fazla
         *  çalısmasını istemiştik. Yani for loopa koyarak bu hata durumunu denemek istersen
         *  Worker Classında değişiklik yapmak gerekecek çünkü şu anki haliyle hata verebilir.
         *  (Hatanın sebebi yukarıda anlattığım gibi queue dolmadan tamamen boşalıyor
         *  ve thread null pointer dönünce ölüyor ve artık çalışmaz hale geliyor)
         *
         */
        BlockingQueue<Job> queue = new ArrayBlockingQueue<Job>(10000);

        Producer producer = new Producer();
        producer.start();

        JobPoller poller = new JobPoller(queue);
        poller.start();

        Worker worker = new Worker(queue);
        worker.start();

    }

}
