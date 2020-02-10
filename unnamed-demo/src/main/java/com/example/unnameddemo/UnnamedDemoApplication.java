package com.example.unnameddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class UnnamedDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnnamedDemoApplication.class, args);
    }

//    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(UnnamedDemoApplication.class);
//        application.addListeners(new ApplicationPidFileWriter("/Users/Gary/unname.pid"));
//        application.run(args);
//    }

}
