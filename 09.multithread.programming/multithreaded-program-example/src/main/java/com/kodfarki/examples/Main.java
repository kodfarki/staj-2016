package com.kodfarki.examples;

import com.kodfarki.examples.dao.JobDAO;
import com.kodfarki.examples.dao.JobDAOImpl;
import com.kodfarki.examples.model.Job;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-config.xml");

        JobDAO jobDAO = applicationContext.getBean(JobDAOImpl.class);

        jobDAO.insert(new Job(0, 1, new Date(), new Date(), 1));
        jobDAO.insert(new Job(0, 2, new Date(), new Date(), 2));

        System.out.println(jobDAO.getJobById(1002));
    }

}
