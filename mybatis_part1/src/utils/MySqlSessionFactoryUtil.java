package utils;

/**
 * Created by Tjl on 2018/8/25 9:02.
 * 返回sqlSession
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MySqlSessionFactoryUtil {

    private static SqlSessionFactory ssf;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (ssf == null) {
            try {
                //1.读取配置文件
                InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
                //2.生成sqlSessionFactory对象
                ssf = new SqlSessionFactoryBuilder().build(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ssf;
    }

    public static SqlSession openSqlSession() {
        return openSqlSession(false);
    }

    public static SqlSession openSqlSession(boolean autoCommit) {
        return getSqlSessionFactory().openSession(autoCommit);
    }
}
