package com.johnbwhitejr.target.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.johnbwhitejr.target.casestudy")
public class MyRetailCaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRetailCaseStudyApplication.class, args);
    }
}
