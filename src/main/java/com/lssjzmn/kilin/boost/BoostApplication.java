package com.lssjzmn.kilin.boost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.lssjzmn.kilin.boost")
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class BoostApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoostApplication.class, args);
    }

}
