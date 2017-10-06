package com.omniwyse.redshiftpoc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;

public class RedshiftDBConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    private static final String dbURL = "jdbc:redshift://spxshift.ckypeqvii6yb.ap-south-1.redshift.amazonaws.com:5439/spx";
    private static final String MasterUsername = "spx";
    private static final String MasterUserPassword = "Genfare!2019";

    public static void main(String[] args) {

        LOGGER.info("INDIPENDENT JAVA class to connect wit redshift and store data to table ***************************** ");

        Connection conn = null;
        Statement stmt = null;
        try {
            // Dynamically load driver at runtime.
            // Redshift JDBC 4.1 driver: com.amazon.redshift.jdbc41.Driver
            // Redshift JDBC 4 driver: com.amazon.redshift.jdbc4.Driver
            Class.forName("com.amazon.redshift.jdbc.Driver");

            // Open a connection and define properties.
            System.out.println("Connecting to database...");
            Properties props = new Properties();

            // Uncomment the following line if using a keystore.
            // props.setProperty("ssl", "true");
            props.setProperty("user", MasterUsername);
            props.setProperty("password", MasterUserPassword);
            conn = DriverManager.getConnection(dbURL, props);

            // Try a simple query.
            System.out.println("Listing system tables...");
            stmt = conn.createStatement();
            String sql;
            sql = "insert into ischool.schools values(1,'zphs','Govt School','2017-09-25 13:36','Asia/calcutta','zphs',1,'zphs.omniwyse.co');";
            int rs = stmt.executeUpdate(sql);
            System.out.println("rs : " + rs);

            // Get the data from the result set.
            // while (rs.next()) {
            // // Retrieve two columns.
            // String catalog = rs.getString("table_catalog");
            // String name = rs.getString("table_name");
            //
            // // Display values.
            // System.out.print("Catalog: " + catalog);
            // System.out.println(", Name: " + name);
            // }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            // For convenience, handle all errors here.
            ex.printStackTrace();
        } finally {
            // Finally block to close resources.
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception ex) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Finished connectivity test.");
    }

}
