package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Properties props = new Properties();
        try(FileReader fr = new FileReader("h2database.properties")) {
            return DriverManager.getConnection("jdbc:h2:~/test", props);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

