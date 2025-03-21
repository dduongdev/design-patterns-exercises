package com.dduongdev;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance = null;
    private final Map<String, String> configurations;
    private Connection connection = null;

    private ConfigurationManager() {
        configurations = new ConcurrentHashMap<>();
        try {
            Properties properties = new Properties();
            properties.load(ConfigurationManager.class.getResourceAsStream("/application.properties"));
            properties.forEach((key, value) -> configurations.put(String.valueOf(key), String.valueOf(value)));
        } catch (IOException ex) {
            System.err.println("Lỗi khi đọc cấu hình: " + ex.getMessage());
        }
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    /**
     * Don't need to use synchronized because ConcurrentHashMap is safe for multi-threading.
     * @author dduongdev
     * @param key
     * @return value: String
     */
    public String getConfiguration(String key) {
        return configurations.get(key);
    }

    public synchronized void updateConfiguration(String key, String value) {
        if (configurations.containsKey(key)) {
        	configurations.put(key, value);
            saveConfigurationsToFile();
        }
    }

    public synchronized void addConfiguration(String key, String value) {
        configurations.put(key, value);
        saveConfigurationsToFile();
    }

    private void saveConfigurationsToFile() {
        try (OutputStream output = new FileOutputStream("resources/application.properties")) {
            Properties properties = new Properties();
            properties.putAll(configurations);
            properties.store(output, "Updated Configuration");
        } catch (IOException e) {
            System.err.println("Lỗi cập nhật file cấu hình: " + e.getMessage());
        }
    }

    public synchronized Connection getDatabaseConnection() throws SQLException {
        if (isDatabaseConnected()) {
            return connection;
        }

        try {
            String driver = configurations.get("database.driver");
            String url = configurations.get("database.url");
            String username = configurations.get("database.username");
            String password = configurations.get("database.password");

            if (driver != null) {
                Class.forName(driver);
            }

            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }

        return connection;
    }

    public boolean isDatabaseConnected() {
        try {
            return (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            return false;
        }
    }
}
