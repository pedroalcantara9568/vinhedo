package com.example.vinhedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.vinhedo"})
public class VinhedoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinhedoApplication.class, args);
    }

}
