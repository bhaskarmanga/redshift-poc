package com.omniwyse.redshiftpoc.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;

@Component
public class DBConnectionProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    private final String host, port, user, password, url;

    @Autowired
    public DBConnectionProperties() {

        LOGGER.info("setting all db properties ********************************** ");

        host = System.getenv().getOrDefault("redshiftpoc_db_host", "spxshift.ckypeqvii6yb.ap-south-1.redshift.amazonaws.com");
        port = System.getenv().getOrDefault("redshiftpoc_db_port", "5439");
        user = System.getenv().getOrDefault("redshiftpoc_db_user", "spx");
        password = System.getenv().getOrDefault("redshiftpoc_db_password", "Genfare!2019");
        
        url = System.getenv().getOrDefault("url", "jdbc:redshift://spxshift.ckypeqvii6yb.ap-south-1.redshift.amazonaws.com:5439/spx");
    }

    public String host() {
        return host;
    }

    public String port() {
        return port;
    }

    public String user() {
        return user;
    }

    public String password() {
        return password;
    }

    public String url() {
        return url;
    }
}
