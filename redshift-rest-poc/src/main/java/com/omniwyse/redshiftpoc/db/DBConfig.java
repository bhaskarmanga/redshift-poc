package com.omniwyse.redshiftpoc.db;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;

@Configuration
public class DBConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    @Autowired
    DBConnectionProperties dbproperties;

    @Bean
    public DataSource dataSource() {

        LOGGER.info("Executing DBConfig ************************************** ");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));

        dataSource.setUrl("jdbc:redshift://spxshift.ckypeqvii6yb.ap-south-1.redshift.amazonaws.com:5439/spx");
        dataSource.setUsername(dbproperties.user());
        dataSource.setPassword(dbproperties.password());

        LOGGER.info(" Returning  DBConfig ************************************** ");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        LOGGER.info(" Returning  JdbcTemplate with datasource  ************************************** ");
        return new JdbcTemplate(dataSource());
    }
}
