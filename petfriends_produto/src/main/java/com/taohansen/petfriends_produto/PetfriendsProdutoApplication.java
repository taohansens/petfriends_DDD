package com.taohansen.petfriends_produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetfriendsProdutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetfriendsProdutoApplication.class, args);
    }

}
