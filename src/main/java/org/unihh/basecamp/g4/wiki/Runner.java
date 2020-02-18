package org.unihh.basecamp.g4.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(Runner.class, args);
        var jobExecutor = applicationContext.getBean(JobExecutor.class);
        var arguments = Arguments.of(args);
        jobExecutor.accept(arguments);
    }
}