package dao;

import bean.User;

import java.util.List;

/**
 * Created by Tjl on 2018/8/30 10:23.
 */
public interface UserDaoMapper {
    //添加用户
    public int insertUser(User user);

    public int insertUserAutoId(User user);

    //删除用户
    public void deleteUserById(Integer id);

    //更新用户
    public int updateUser(User user);

    //查询一个学生信息
    public User findUserById(Integer id);

    //查询所有学生信息，封装为list集合
    public List<User> findAllUsers();


    public User findUserByUsername(String username);
}
