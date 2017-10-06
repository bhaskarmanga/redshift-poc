package com.omniwyse.redshiftpoc.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dieselpoint.norm.Database;
import com.omniwyse.redshiftpoc.RedShiftRestPOC;

@Component
public class DBFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);


    private final Database redshiftDB;

    @Autowired
    public DBFactory(DBConnectionProperties dbproperties) {

        LOGGER.info("Preparing database to access *********************************** ");

        System.setProperty("norm.jdbcUrl", "jdbc:redshift://spxshift.ckypeqvii6yb.ap-south-1.redshift.amazonaws.com:5439/spx");
        System.setProperty("norm.user", dbproperties.user());
        System.setProperty("norm.password", dbproperties.password());
        redshiftDB = new Database();
    }

    public Database getredshiftDB() {
        return redshiftDB;
    }
}
