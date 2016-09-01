package com.kodfarki.examples.thread;

import com.kodfarki.examples.dao.JobDAOImpl;
import com.kodfarki.examples.model.Job;
import com.sun.tools.javac.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataStore {

    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-config.xml");

    public List<Job> consume(){
        return getInstance().context.getBean(JobDAOImpl.class).getJobById();
    }

    public void produce(Job job) {
        getInstance().context.getBean(JobDAOImpl.class).insert(job);
    }

    private DataStore() {
    }

    private static com.kodfarki.examples.thread.DataStore me;

    public static com.kodfarki.examples.thread.DataStore getInstance(){

        if (me == null) {
            me = new com.kodfarki.examples.thread.DataStore();
        }
        return me;
    }
}
