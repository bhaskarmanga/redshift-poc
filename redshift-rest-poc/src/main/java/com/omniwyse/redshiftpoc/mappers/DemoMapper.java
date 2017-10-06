package com.omniwyse.redshiftpoc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;
import com.omniwyse.redshiftpoc.models.FileDemo;

@Component
public class DemoMapper implements RowMapper<FileDemo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    @Override
    public FileDemo mapRow(ResultSet rs, int rowNum) {

        LOGGER.info("Mapping the table properties ****************************** ");

        FileDemo fileDemo = new FileDemo();
        try {
            fileDemo.setProduct(rs.getString("product"));
            fileDemo.setAccounttype(rs.getString("accounttype"));
            fileDemo.setCardtype(rs.getString("cardtype"));
            fileDemo.setCountofproducts(rs.getLong("countofproducts"));
            fileDemo.setProductprice(rs.getFloat("productprice"));
            fileDemo.setTotalprice(rs.getFloat("totalprice"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fileDemo;
    }

}
