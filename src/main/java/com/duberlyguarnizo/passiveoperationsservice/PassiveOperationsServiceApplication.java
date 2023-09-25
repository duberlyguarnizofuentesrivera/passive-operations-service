/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * The main class for the Passive Operations Service Application.
 * This class is responsible for starting the application.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class PassiveOperationsServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(PassiveOperationsServiceApplication.class, args);
  }

}
