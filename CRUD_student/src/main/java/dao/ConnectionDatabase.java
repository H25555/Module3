package dao;


import java.sql.*;

public class ConnectionDatabase {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_crud";
    private String jdbcUsername = "root";

    private String jdbcPassword = "hung250403";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
