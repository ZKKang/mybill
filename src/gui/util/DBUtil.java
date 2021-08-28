package gui.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "mybill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        String url = String.format("jdbc:mysql://127.0.0.1:3306/mybill?characterEncoding=UTF-8");
        return DriverManager.getConnection(url,"root","admin");
    }
}
