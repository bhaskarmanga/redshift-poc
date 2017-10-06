package com.omniwyse.redshiftpoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.omniwyse.redshiftpoc.db.DBConnectionProperties;
import com.omniwyse.redshiftpoc.db.DBFactory;

//@Service
public class FlywayRunner {

    private final String jdbcUrl, user, password;
    private DBFactory dbFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayRunner.class);

    // @Autowired
    public FlywayRunner(DBConnectionProperties db, DBFactory dbFactory) {

        LOGGER.info("Starting flyway to migrate the scemas ********************************** ");

        this.jdbcUrl = "jdbc:redshift://spxshift.ckypeqvii6yb.ap-south-1.redshift.amazonaws.com:5439/spx";
        this.user = db.user();
        this.password = db.password();
        this.dbFactory = dbFactory;
        migrate("ischool");
    }

    private void migrate(String schema) {
        // LOGGER.info("Migrating schema {}", schema);
        // Flyway flyway = new Flyway();
        // flyway.baseline();
        // flyway.setLocations("db/migration/" + schema);
        // flyway.setSchemas(schema);
        // flyway.setDataSource(String.format(jdbcUrl, schema), user, password);
        // flyway.migrate();
        // try {
        // flyway.getDataSource().getConnection().close();
        // } catch (SQLException e) {
        // LOGGER.warn("Failed to close flyway datasource connection", e);
        // }
    }
}
