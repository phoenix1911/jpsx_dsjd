package test;

import mappers.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Tjl on 2018/8/24 16:46.
 */
public class Test1_StudentBase {
    @Test
    public void test_baseInsert(){

        //读取mybaties-config.xml
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //获取SqlSessionFactory对象[通过配置文件]
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取SqlSession对象
            SqlSession session = factory.openSession();
        //获取映射接口的实现类对象 ,获取到了Dao层对象
            StudentMapper mapper = session.getMapper(StudentMapper.class);

            Student student = new Student(99, "九九", "123@qq.com", new Date());
            mapper.insertStudent(student);
            session.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
