package jdbc;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Logger;


public class CustomDataSource implements DataSource {
    private static volatile CustomDataSource instance;
    private static Connection connection;
    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/myfirstdb";
    private static final String name = "postgres";
    private static final String password = "1234";
    private PrintWriter log;
    private int loginTimeout;

    private CustomDataSource() {
        CustomConnector cc = new CustomConnector();
        connection = cc.getConnection(CustomDataSource.url, CustomDataSource.name, CustomDataSource.password);
    }

    public static CustomDataSource getInstance()  {
        if (instance == null) {
            instance = new CustomDataSource();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            CustomConnector connector = new CustomConnector();
            connection = connector.getConnection(url, name, password);
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) {
        if (connection == null) {
            CustomConnector cc = new CustomConnector();
            return cc.getConnection(url, username, password);
        }
        return connection;
    }

    @Override
    public PrintWriter getLogWriter(){
        return log;
    }

    @Override
    public void setLogWriter(PrintWriter out){
        log = out;
    }

    @Override
    public void setLoginTimeout(int seconds) {
        loginTimeout = seconds;
    }

    @Override
    public int getLoginTimeout() {
        return loginTimeout;
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        return false;
    }
}

