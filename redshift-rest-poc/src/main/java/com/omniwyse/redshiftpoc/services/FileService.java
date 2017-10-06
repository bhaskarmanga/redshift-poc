package com.omniwyse.redshiftpoc.services;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;
import com.omniwyse.redshiftpoc.models.FileDemo;

@Service
public class FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    @Autowired
    JdbcTemplate jdbctemplate;

    public Collection<FileDemo> getFile() {
        return null;
    }

    public boolean uploadFile(String filepath) {

        LOGGER.info("Uploading file to redshift ********************* ");

        String sql = "copy demo from " + filepath + " iam_role 'arn:aws:iam::042649463841:role/s3toredshift' csv;";

        jdbctemplate.execute(sql);

        return true;
    }
}
