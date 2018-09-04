package service;

import bean.User;
import dao.UserDao;
import dao.UserDaoMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.Random;

/**
 * Created by Tjl on 2018/8/18 17:41.
 */
public class UserService {

    private UserDao userDao = new UserDao();
    //登陆
    public Boolean login(String username, String password) {
        //和数据库数据进行比对
//        UserDao userDao = new UserDao();
//        User user = userDao.selectByUsername(username);
//        System.out.println(user);

        UserDaoMapper mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(UserDaoMapper.class);
        User user = mapper.selectUserByUserName(username);
        System.out.println(user);

        if (user!=null){
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //注册
    public Boolean register(String username,String password,String phone) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        Random random = new Random();
        int i = random.nextInt(100);

        User user2 = new User(i,username,password,phone);
        mapper.insertUser(user2);
        return true;
    }


    public static void main(String[] args) {
        UserService userService = new UserService();
//        userService.register(40,)
//        System.out.println(login);

    }

    /**
     * 根据username获取User对象
     * @param username
     * @return
     */
    public User showByUsername(String username) {

        return userDao.selectByUsername(username);
    }
}
