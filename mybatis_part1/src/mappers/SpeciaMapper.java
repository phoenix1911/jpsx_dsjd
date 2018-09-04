package mappers;

import special.User;

/**
 * Created by Tjl on 2018/8/29 9:50.
 */
public interface SpeciaMapper {
    public void insertUser(User user);
    public User findUserById_test(Integer id);
//    public void insertUserPic(UserPic userPic);
//    public UserPic getUserPicById(Integer id);
//    public List<User> findAllUsers(RowBounds rowBounds);
    public User findUserById(Integer id);
}
