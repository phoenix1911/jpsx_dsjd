package service;

import bean.User;

/**
 * Created by Tjl on 2018/8/30 11:32.
 */
public interface UserService {
    public boolean register(User user);

    public boolean login(User user);

    public User findUserByUsername(String username);

    public User findUserById(int id);

    public boolean UpdateUserById(String username,String zip,String phone,String email);

    public int updateUserPwdByUsername(String username, String oldpassword, String newpassword, String repassword);
}
