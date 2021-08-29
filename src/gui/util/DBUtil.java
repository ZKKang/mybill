package gui.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static Properties properties= null;
    static {
        properties= new Properties();
        try {
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.property"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static {
        try{
            Class.forName(getValue("driver"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static String getValue(String key) {
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        }else
            throw new KeyNotFoundException("未找到对应的key ："+key);
    }


    public static Connection getConnection() throws SQLException{
        String url = String.format("jdbc:mysql://%s:%s/%s?characterEncoding=%s", getValue("ip"), getValue("port"), getValue("database"), getValue("encoding"));
        return DriverManager.getConnection(url,getValue("username"),getValue("password"));
    }


}
class KeyNotFoundException extends RuntimeException {
    public KeyNotFoundException() {
        super();
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}