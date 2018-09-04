package test;

import mappers.SpeciaMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import special.Gender;
import special.User;
import utils.MySqlSessionFactoryUtil;

/**
 * Created by Tjl on 2018/8/29 10:00.
 */
public class Test7_SpecialMapper {
    @Test
    public void demo1_insertS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        SpeciaMapper mapper = session.getMapper(SpeciaMapper.class);
        User user = new User(1, "zs", Gender.FEMALE);
        System.out.println(Gender.MALE.ordinal());
        mapper.insertUser(user);
        session.commit();

    }

}
