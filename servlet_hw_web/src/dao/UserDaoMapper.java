package dao;

import bean.User;

/**
 * Created by Tjl on 2018/9/2 21:06.
 */
public interface UserDaoMapper {
    public User selectUserByUserName(String Username);

    public int insertUser(User user);

}
