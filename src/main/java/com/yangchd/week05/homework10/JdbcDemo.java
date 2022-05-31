package com.yangchd.week05.homework10;


import java.sql.*;

public class JdbcDemo {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "admin";
        String password = "admin";

        return DriverManager.getConnection(url, username, password);
    }

    public void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void select() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sql = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id"));
        }

        closeResource(connection, preparedStatement, rs);
    }

    public void add() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sql = "insert into user(id,age) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, 18);
        int count = preparedStatement.executeUpdate();

        closeResource(connection, preparedStatement, null);
    }

    public void delete() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        int count = preparedStatement.executeUpdate();

        closeResource(connection, preparedStatement, null);
    }

    public void update() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sql = "update user user set age=? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 20);
        preparedStatement.setInt(1, 1);
        int count = preparedStatement.executeUpdate();

        closeResource(connection, preparedStatement, null);
    }
}
