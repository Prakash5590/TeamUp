package com.teamup.naming.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceNameRegistry {
    public static void main ( String[] args ){
        SpringApplication.run(ServiceNameRegistry.class, args);
    }
}
