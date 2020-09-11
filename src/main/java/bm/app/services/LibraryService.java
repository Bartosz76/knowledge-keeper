package bm.app.services;

import bm.app.models.LinkToCheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static bm.app.config.Constants.*;

public class LibraryService {

    private void insertRecord(LinkToCheck linkToCheck) {
        String sql = "insert into forfutureuse (link_name, added_on) values (?, ?)";
        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, linkToCheck.getLink_name());
            preparedStatement.setDate(2, linkToCheck.getAdded_on());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection connection = createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
        if (connection == null) {
            return null;
        }
        return connection;
    }

    private Connection createConnection(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
