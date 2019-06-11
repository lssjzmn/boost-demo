package com.lssjzmn.kilin.boost.provider.boostprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
@EnableAutoConfiguration
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class BoostProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoostProviderApplication.class, args);
    }

}
