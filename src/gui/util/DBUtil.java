package gui.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

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
