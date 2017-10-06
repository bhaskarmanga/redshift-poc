package com.omniwyse.redshiftpoc;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
// @EnableBatchProcessing
public class RedShiftRestPOC {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    public static void main(String[] args) {

        LOGGER.info("Starting Redshift POC API *******************************");

        // SpringApplication.run(RedShiftRestPOC.class, args);
        
        ApplicationContext apcontext = SpringApplication.run(RedShiftRestPOC.class, args);
        CamelSpringBootApplicationController applicationController = apcontext.getBean(CamelSpringBootApplicationController.class);
        applicationController.run();
    }

}
