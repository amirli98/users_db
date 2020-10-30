package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        String jdbcUrl = "jdbc:mysql://localhost:3306/sampleDb";
        String username = "root";
        String password = "1234";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "INSERT INTO users (username,email,fullname,password)"
                    +"VALUES ('fzamirli','azfazilamirli@gmail.com','Fazil Amirli','password')";
            String query = "INSERT INTO users (username,email,fullname,password)"
                    +"VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
              preparedStatement.setString(1,"username");
              preparedStatement.setString(2,"username.user@anymail.com");
              preparedStatement.setString(3,"John Doe");
              preparedStatement.setString(4,"password");
              preparedStatement.executeUpdate();
            }
            try (Statement statement = connection.createStatement()) {
              int rows=statement.executeUpdate(sql);
              if (rows>0)
              {
                  System.out.println("The new user inserted successfully");
              }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
