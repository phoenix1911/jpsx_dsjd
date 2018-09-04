package test;

import mappers.SpecialMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Gender;
import pojo.User;
import util.MySqlSessionFactoryUtil;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Tjl on 2018/8/29 10:00.
 */
public class Test7_SpecialMapper {
    @Test //ok
    public void demo1_insertS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        SpecialMapper mapper = session.getMapper(SpecialMapper.class);
        for (int i=3;i<15;i++){
        User user = new User(i, "zs", Gender.FEMALE);
        mapper.insertUser(user);}
//        System.out.println(Gender.MALE.oridinal());
        session.commit();
    }

    @Test
    public void test2_row() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        SpecialMapper mapper = session.getMapper(SpecialMapper.class);
        int n = 0;
        int num = 5;
        int offset = (n-1)*num;
        RowBounds rowBounds = new RowBounds(offset, num);
        List<User> allUsersWithRowBounds = mapper.findAllUsersWithRowBounds(rowBounds);
        for (User u :
                allUsersWithRowBounds) {
            System.out.println(u);
        }
        session.commit();
    }

//    一级缓存
    @Test
    public void Test2_cache() throws ParseException {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        SpecialMapper mapper = session.getMapper(SpecialMapper.class);

        User u1 = mapper.findUserById(1);
        System.out.println(u1);
        User u2 = mapper.findUserById(2);
        System.out.println(u2);
        session.commit();
    }

    //    二级缓存 两个session中相同的select可以共享,
    // 1.XXXMapper.xml里加<cache/>
    // 2.第一条select之后要执行commit,close
    // 3.不能执行DML
    @Test
    public void Test2_cache2() throws ParseException {
        SqlSession session1 = MySqlSessionFactoryUtil.openSqlSession();
        SqlSession session2 = MySqlSessionFactoryUtil.openSqlSession();
        SpecialMapper mapper1 = session1.getMapper(SpecialMapper.class);
        SpecialMapper mapper2 = session2.getMapper(SpecialMapper.class);

        User u1 = mapper1.findUserById(1);
        System.out.println(u1);
        session1.commit();
        User u2 = mapper2.findUserById(2);
        System.out.println(u2);


    }


}
