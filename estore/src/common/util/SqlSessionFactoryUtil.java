package common.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Tjl on 2018/8/30 9:37.
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            InputStream resourceAsStream = null;
            try {
                resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    private SqlSessionFactoryUtil() {

    }

    //获得sqlSession对象
    public static SqlSession getSqlSession(boolean autoCommit) {
        SqlSession session = getSqlSessionFactory().openSession(autoCommit);
        return session;
    }
    public static SqlSession getSqlSession() {
        return getSqlSession(false);
    }

}
