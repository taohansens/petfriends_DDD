package com.taohansen.petfriends_eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PetfriendsEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetfriendsEurekaserverApplication.class, args);
    }

}
