package bm.app.services;

import bm.app.models.LinkToCheck;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static bm.app.config.Constants.*;

@Service
public class LibraryService {

    public void insertRecord(LinkToCheck linkToCheck) {
        String sql = "insert into forfutureuse (link_name, description, added_on) values (?, ?, ?)";
        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, linkToCheck.getLink_name());
            preparedStatement.setString(2, linkToCheck.getDescription());
            preparedStatement.setDate(3, linkToCheck.getAdded_on());
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
