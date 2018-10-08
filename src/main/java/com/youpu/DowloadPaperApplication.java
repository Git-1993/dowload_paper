package com.youpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class DowloadPaperApplication extends SpringBootServletInitializer implements WebApplicationInitializer{
    /*@Override

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(DowloadPaperApplication.class);
    }*/
    public static void main(String[] args) {
        SpringApplication.run(DowloadPaperApplication.class, args);
    }
}
