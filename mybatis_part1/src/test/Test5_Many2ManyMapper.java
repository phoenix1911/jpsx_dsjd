package test;

import Many2Many.Course;
import Many2Many.Many2ManyMapper;
import Many2Many.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import utils.MySqlSessionFactoryUtil;

import java.util.List;

/**
 * Created by Tjl on 2018/8/28 15:03.
 */
public class Test5_Many2ManyMapper {
    @Test
    public void test1_insertS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        session.commit();

    }
    @Test
    public void test3_Select() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        session.commit();

    }

    @Test
    public void test4_SelectS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        session.commit();

    }

    @Test
    public void test5_SelectS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        Student studentByIdWithCourses = mapper.getStudentByIdWithCourses(13);
        System.out.println(studentByIdWithCourses);
        List<Course> courses = studentByIdWithCourses.getCourses();
        System.out.println(courses);

        session.commit();

    }
}
