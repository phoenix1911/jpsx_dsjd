package test;

import bean.User;
import dao.UserDao;
import dao.UserDaoMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.SqlSessionFactoryUtil;

import java.util.Random;

/**
 * Created by Tjl on 2018/9/2 21:17.
 */
public class UserTest {
    @Test
    public void Demo1_User() {
        UserDaoMapper mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(UserDaoMapper.class);
        User user = mapper.selectUserByUserName("rrr");
        System.out.println(user);
    }

    @Test
    public void test_insert() {
        UserTest userTest = new UserTest();
        userTest.insert("111","111","111");
    }



    public void insert(String username,String password,String phone) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        Random random = new Random();
        int i = random.nextInt(100);

        User user2 = new User(i,username,password,phone);
        mapper.insertUser(user2);

    }

}
