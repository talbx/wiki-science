package org.unihh.basecamp.g4.wiki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements ApplicationRunner {

    @Value("${jobName}")
    private String jobName;

    @Value("${jobInput}")
    private String jobInput;

    @Value("${jobOutput}")
    private String jobOutput;

    @Autowired
    private JobExecutor jobExecutor;

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) {
        System.out.println(jobName + jobInput + jobOutput);
        var arguments = Arguments.of(jobName, jobInput, jobOutput);
        jobExecutor.accept(arguments);
    }
}