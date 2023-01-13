package org.teachmeskills.jdbc.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    private static Connect connect;
    private final Connection connection;

    private Connect() {
        try (FileInputStream in = new FileInputStream("D:\\Workspace\\TeachMeSkills\\Extended\\jdbc-app\\src\\main\\resources\\db.properties")) {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            properties.load(in);
            String url = properties.getProperty("db.url");
            String login = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connect getInstance() {
        if (connect == null) {
            connect = new Connect();
        }
        return connect;
    }

    public Connection getConnection() {
        return connection;
    }

}
