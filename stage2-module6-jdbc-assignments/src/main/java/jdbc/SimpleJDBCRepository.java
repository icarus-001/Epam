package jdbc;


import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SimpleJDBCRepository {
    private static final String createUserSQL = "INSERT INTO myusers VALUES (%s, %s, %s, %s)";
    private static final String updateUserSQL = "";
    private static final String deleteUser = "DELETE FROM myusers WHERE id = (%s)";
    private static final String findUserByIdSQL = "SELECT * FROM myusers WHERE ID = ";
    private static final String findUserByNameSQL = "SELECT * FROM myusers WHERE firstName = ";
    private static final String findAllUserSQL = "SELECT * FROM myusers ";


    private Connection connection = CustomDataSource.getInstance().getConnection();
    private PreparedStatement ps = null;
    private Statement st;

    public SimpleJDBCRepository() throws SQLException {
        try {
            connection = CustomDataSource.getInstance().getConnection();
            st = connection.createStatement();
            st.execute("""
        CREATE TABLE myusers ( firstName varchar(100),
        lastName varchar(100),
        id int,
        age int,
        PRIMARY KEY (id) );
        """);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Long createUser(User newUser) {
        try {
            st = connection.createStatement();
            st.execute(String.format(createUserSQL,
                    newUser.getId(), newUser.getFirstName(), newUser.getLastName(), newUser.getAge()));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return newUser.getId();
    }

    public User findUserById(Long userId)  {

        ResultSet result;
        try {
            st = connection.createStatement();

            result = st.executeQuery(findUserByIdSQL + userId);
            String fn = result.getString(1);
            String ln = result.getString(2);
            int age = result.getInt(3);
            return new User(userId, fn, ln, age);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findUserByName(String userName) {
        try {
            st = connection.createStatement();

            ResultSet result = st.executeQuery(findUserByNameSQL + userName);
            Long id = result.getLong(0);
            String ln = result.getString(2);
            int age = result.getInt(3);
            return new User(id, userName, ln, age);
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAllUser()  {
        ArrayList<User> Users = new ArrayList<>();
        try {
            st = connection.createStatement();

            ResultSet result = st.executeQuery(findAllUserSQL);
            while (result.next()) {
                Long id = result.getLong(0);
                String fn = result.getString(1);
                String ln = result.getString(2);
                int age = result.getInt(3);
                Users.add(new User(id, fn, ln, age));

            }
            return Users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public User updateUser(User user) {
        try {
            st = connection.createStatement();

            st.execute(createUserSQL + user.getId() + ", " +
                    user.getFirstName() + ", " +
                    user.getLastName() + ", " +
                    user.getAge() + " )"
            );
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(Long userId)  {
        try {
            st = connection.createStatement();

            st.execute(String.format(deleteUser, userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
