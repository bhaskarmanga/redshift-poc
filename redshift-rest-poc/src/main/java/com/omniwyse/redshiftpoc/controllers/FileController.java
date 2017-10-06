package com.omniwyse.redshiftpoc.controllers;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;

@RestController
public class FileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    @Autowired
    ProducerTemplate producerTemplate;

    @RequestMapping(value = "/uploadfile")
    public boolean uploadFile() {

        LOGGER.info("Rest call for file upload is triggered ******************** ");

        producerTemplate.setDefaultEndpointUri("direct:fileupload");
        producerTemplate.sendBody("direct:fileupload");

        return true;
    }

}
