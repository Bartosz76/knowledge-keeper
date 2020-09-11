package bm.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static bm.app.config.Constants.*;

public class LibraryService {

    private Connection getConnection() {
        Connection connection = createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
        if (connection == null) {
            return null;
        }
        return connection;
    }

    Connection createConnection(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
