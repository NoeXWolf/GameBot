package fr.noexwolf.gamebot.database;

import fr.noexwolf.gamebot.properties.PropertiesManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private PropertiesManager propertiesManager;
    private Connection connection;

    public DatabaseManager() {
        try {
            propertiesManager = new PropertiesManager("database.properties");
            connection = new MySQLConnection(
                    propertiesManager.getProperty("host"),
                    propertiesManager.getProperty("port"),
                    propertiesManager.getProperty("database"),
                    propertiesManager.getProperty("user"),
                    System.getenv("MYSQL_PASSWORD")
            ).getConnection();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String request) throws SQLException {
        return connection.prepareStatement(request);
    }

}
