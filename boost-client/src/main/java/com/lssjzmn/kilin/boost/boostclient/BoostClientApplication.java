package com.lssjzmn.kilin.boost.boostclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = "com.lssjzmn.kilin.boost.boostclient")
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class BoostClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoostClientApplication.class, args);
    }

}
