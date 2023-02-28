package com.s1.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.s1.main", "com.s1.pe", "s1.pda"})
@SpringBootApplication
public class XonePdaWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(XonePdaWebApplication.class, args);
    }
}
