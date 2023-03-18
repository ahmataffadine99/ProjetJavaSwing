package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnexion {

    private Connection connection;

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/biblio";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    public void connect() {
        String url = "jdbc:mysql://localhost:3306/biblio";

        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public int executeUpdate(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeUpdate();
    }
}
