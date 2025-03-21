package com.dduongdev;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable readConfigTask = () -> {
            String dbUrl = configManager.getConfiguration("database.url");
            System.out.println(Thread.currentThread().getName() + " - Database URL: " + dbUrl);
        };

        Runnable updateConfigTask = () -> {
            String threadName = Thread.currentThread().getName();
            configManager.updateConfiguration("server.ip", "192.168.0.1");
            System.out.println(threadName + " - Updated server.ip to: " + configManager.getConfiguration("server.ip"));
        };
        
        Runnable addConfigTask = () -> {
        	String threadName = Thread.currentThread().getName();
        	configManager.addConfiguration("server.port", "8080");
        	System.out.println(threadName + " - Added server.port: " + configManager.getConfiguration("server.port"));
        };

        @SuppressWarnings("unused")
		Runnable dbConnectionTask = () -> {
            try {
                Connection connection = configManager.getDatabaseConnection();
                if (configManager.isDatabaseConnected()) {
                    System.out.println(Thread.currentThread().getName() + " - Database connected successfully!");
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Database connection failed!");
                }
            } catch (SQLException e) {
                System.err.println(Thread.currentThread().getName() + " - Database error: " + e.getMessage());
            }
        };

        for (int i = 0; i < 3; i++) {
            executor.execute(readConfigTask);
            executor.execute(updateConfigTask);
            executor.execute(addConfigTask);
            executor.execute(dbConnectionTask);
        }

        executor.shutdown();
    }
}
