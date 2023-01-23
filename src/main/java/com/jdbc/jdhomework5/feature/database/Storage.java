package com.jdbc.jdhomework5.feature.database;

import com.jdbc.jdhomework5.feature.pref.Pref;

import java.sql.*;

public class Storage {
    private static final Storage instance = new Storage();
    private Connection connection;

    private Storage() {
        try {
            String connectionUrl = new Pref().getString(Pref.DATABASE_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet executeQuery(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Storage getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
