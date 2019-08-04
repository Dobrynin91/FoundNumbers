package ru.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Connection to MySQL database
 *
 * @author Philipp
 */
public class ConnectionClass {

    private static Logger logger = LoggerFactory.getLogger(Connection.class);

    private static final String URL = "jdbc:mysql://localhost:3306/example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     *
     * return the connection to database
     * @return
     */
    public static Connection getConnection() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Connection to database is successful");
            return connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.error("Connection to database error");
        }
        return null;
    }

}
