package test;

import bean.User;
import common.util.SqlSessionFactoryUtil;
import dao.UserDaoMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Tjl on 2018/8/30 10:40.
 */
public class UserTest {
    @Test
    public void demo1_insertUser() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User(3, "qqq", "qqq", "zip123456", "12345678", "123@qq.com", new Date(), 1);
        mapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void demo1_insertUserAutoId() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User("qqq", "qqq", "zip123456", "12345678", "123@qq.com", new Date(), 1);
        mapper.insertUserAutoId(user);
        sqlSession.commit();
    }

    @Test
    public void demo2_findUserById() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = mapper.findUserById(3);
        System.out.println(user);
        sqlSession.commit();
    }

    @Test
    public void demo2_findUserByUsername() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = mapper.findUserByUsername("aaa");
        System.out.println(user);
        sqlSession.commit();
    }

    @Test
    public void demo3_findAllUser() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        List<User> allusers = mapper.findAllUsers();
        System.out.println(allusers);
        sqlSession.commit();
    }

    @Test
    public void demo4_deleteUserById() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        mapper.deleteUserById(3);
        sqlSession.commit();
    }

    @Test
    public void demo5_updateUser() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User ttt = mapper.findUserByUsername("ttt");
        System.out.println(ttt);
        ttt.setZip("1");
        ttt.setPhone("12");
        ttt.setEmail("1@qq.com");
        System.out.println(ttt);
        mapper.updateUser(ttt);
        sqlSession.commit();
    }


}
