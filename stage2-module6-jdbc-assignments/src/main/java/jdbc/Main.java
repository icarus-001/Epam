package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        CustomConnector connector = new CustomConnector();
        Connection cc = connector.getConnection("jdbc:postgresql://localhost:5432/postgres");
        try {
            Statement st = cc.createStatement();
        } catch (SQLException e) {
            System.out.println("exception occured");
        }
//        SimpleJDBCRepository jd = new SimpleJDBCRepository();
//        System.out.println(jd.getConnection() == null);

    }
}
