package org.example.utlis;

import java.sql.*;

public class DBUtils {

    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "123456789";
    private static final String DATABASE_NAME = "dbQLBanHang";
    private static final String SERVER_NAME = "ASUS\\ASUS";
    private static final String PORT = "1433";

    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:" + PORT + ";databaseName=" +
            DATABASE_NAME + ";user=" + USER_NAME + ";password=" + PASSWORD + ";encrypt=false;";

    private static Connection connection;

    public static boolean connect() {
        try
        {
            connection = DriverManager.getConnection(DATABASE_URL);
            if(connection != null)
                return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean disconnect() {
        try
        {
            if(connection != null)
                connection.close();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public static void executeUpdate(String sql) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
    }

}
