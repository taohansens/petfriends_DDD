package org.taohansen.petfriends_almoxarifado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetfriendsAlmoxerifadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetfriendsAlmoxerifadoApplication.class, args);
    }

}
