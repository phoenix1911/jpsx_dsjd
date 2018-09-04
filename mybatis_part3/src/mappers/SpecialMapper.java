package mappers;


import org.apache.ibatis.session.RowBounds;
import pojo.Student;
import pojo.User;

import java.util.List;

/**
 * Created by Tjl on 2018/8/29 9:50.
 */
public interface SpecialMapper {
    public void insertUser(User user);

    public User findUserById_test(Integer id);

//  public void insertUserPic(UserPic userPic);
//  public UserPic getUserPicById(Integer id);

    public List<User> findAllUsersWithRowBounds(RowBounds rowBounds);

    public User findUserById(Integer id);

    public Student findStudentByNameAndEmail(String name, String email);

    public User findAllUsers();
}
