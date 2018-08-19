package util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Tjl on 2018/8/18 17:39.
 */
public class DBUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;


    static{
        Properties properties = new Properties();
        try {
            properties.load(DBUtil.class.getResourceAsStream("DB.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1.获取数据库 连接对象
    public static Connection getConnection() throws Exception {
        //1.注册驱动
        Class.forName(driver);
        //2.建立数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return  connection;
    }

    //关闭资源 connection statement ps rs
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(resultSet!=null)
                resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        try {
            if(statement!=null)
                statement.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        try {
            if(connection!=null)
                connection.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    //关闭资源 connection statement ps rs
    public static void close(Connection connection,Statement statement) {

        try {
            if(statement!=null)
                statement.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        try {
            if(connection!=null)
                connection.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
        try {
            System.out.println(DBUtil.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
