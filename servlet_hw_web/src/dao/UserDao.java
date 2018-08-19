package dao;

import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Tjl on 2018/8/18 17:39.
 */
public class UserDao extends DBUtil {
    //根据username查询对应的user

    public User selectByUsername(String username) {
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from servlet_hw_web_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String phone = resultSet.getString(4);
                user = new User(id, name, password, phone);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void insertUser(User user) {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        String sql = "insert into servlet_hw_web_user values(?,?,?,?)";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }






    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.selectByUsername("tjl");
        System.out.println(user);
//        User user2 =new User(4,"tjl","tjl","123456");
//        userDao.insertUser(user2);
    }
}
