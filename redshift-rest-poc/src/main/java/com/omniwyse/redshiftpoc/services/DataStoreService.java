package com.omniwyse.redshiftpoc.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.redshiftpoc.RedShiftRestPOC;
import com.omniwyse.redshiftpoc.db.DBFactory;
import com.omniwyse.redshiftpoc.models.Schools;

@Service
public class DataStoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    private Database db;

    @Autowired
    private DBFactory factory;

    public boolean storeData(Schools school) throws SQLException {

        LOGGER.info("Stpring the data of json format ********************************** ");

        db = factory.getredshiftDB();

        Date date = school.getDateofestablishment();

        try {
            
            // String sql = "insert into ischool.schools values(" +2 +",'" +
            // school.getCode() + "'," + "'" + school.getSname()
            // + "','" + school.getDateofestablishment() + "','" +
            // school.getTimezone() + "','" + school.getDbname() + "',"
            // + school.getStatusid() + ",'" + school.getUrl() + "'" + ");";
            db.insert(school);
            // db.getConnection().createStatement().executeUpdate(sql);

            // db.sql("insert into ischool.schools values(1,'zphs','Govt School','20170215 04:05:06.789','Asia/calcutta','zphs',1,'zphs.omniwyse.co')").results(Schools.class);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Schools> getData() {

        LOGGER.info("Getting the data in json format ***************************** ");

        db = factory.getredshiftDB();
        return db.sql("select * from ischool.Schools").results(Schools.class);
    }
}
