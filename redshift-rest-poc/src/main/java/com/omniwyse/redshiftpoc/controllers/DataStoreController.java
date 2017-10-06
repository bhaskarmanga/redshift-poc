package com.omniwyse.redshiftpoc.controllers;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;
import com.omniwyse.redshiftpoc.models.Schools;
import com.omniwyse.redshiftpoc.services.DataStoreService;

@Controller
public class DataStoreController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    @Autowired
    DataStoreService dataStoreService;

    @RequestMapping(value = "/getdata")
    public ResponseEntity<?> getData() {
        
        LOGGER.info("getting data using json ************************************ ");

        return new ResponseEntity<List<Schools>>(dataStoreService.getData(), HttpStatus.OK);

    }

    @RequestMapping(value = "/storedata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> storeData(@RequestBody Schools school) {

        LOGGER.info("Stroring data using json obj *********************************** ");

        try {
            return new ResponseEntity<Boolean>(dataStoreService.storeData(school), HttpStatus.OK);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

}
