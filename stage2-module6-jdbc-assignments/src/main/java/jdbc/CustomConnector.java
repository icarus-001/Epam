package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class CustomConnector {
    public Connection getConnection(String url) {
        Properties props = new Properties();
        try (InputStream input = CustomConnector.class.getClassLoader().getResourceAsStream("app.properties")) {
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String username = props.getProperty("user");
        String password = props.getProperty("password");
        try {
            return DriverManager.getConnection(url,username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection getConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

