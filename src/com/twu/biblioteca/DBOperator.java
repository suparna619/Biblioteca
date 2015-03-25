package com.twu.biblioteca;
import java.util.*;
import java.sql.*;

public class DBOperator {
    public static void main(String[] args) throws Exception {
        int result = 0;
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        Properties info = new Properties( );
        info.put( "user", "LIBRARY_REG" );
        info.put( "password", "LIBRARY" );
        Connection conn = DriverManager.getConnection(URL, info);
        ResultSet resultSet = execute("SELECT * FROM library_members",conn);
        while(resultSet.next()){
            System.out.println("id = "+resultSet.getString(1)+" name = "+resultSet.getString(2));
            result += resultSet.getInt(2);
        }
        System.out.println(result);
    }
    public static ResultSet execute(String sqlCommand,Connection conn) {
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = conn.prepareStatement(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}