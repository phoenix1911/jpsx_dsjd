package test;

import Many2Many.Course;
import mappers.Many2ManyMapper;
import Many2Many.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import utils.MySqlSessionFactoryUtil;

import java.util.List;

/**
 * Created by Tjl on 2018/8/28 15:03.
 */
public class Test5_Many2ManyMapper {
    @Test//ok
    public void test1_insertS(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        Student s1 = new Student("李四", "M", "计算机", "大二");
        Student s2 = new Student("王五", "F", "测控", "大二");

        mapper.insertStudent(s1);
        mapper.insertStudent(s2);

        session.commit();
    }
    @Test//ok
    public void test2_insertC(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        Course c1 = new Course("100", "形势与政策");
        Course c2 = new Course("101", "马克思主义");
        Course c3 = new Course("102", "体育舞蹈");
        Course c4 = new Course("103", "高数");
        mapper.insertCourse(c1);
        mapper.insertCourse(c2);
        mapper.insertCourse(c3);
        mapper.insertCourse(c4);

        session.commit();
    }

    @Test
    public void test3_select(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        Student s1 = mapper.getStudentById(237);
        Many2Many.Student s2 = mapper.getStudentById(238);
        System.out.println(s1.getClass());
        System.out.println(s2.getClass());
        Course c1 = mapper.getCourseById(14);
        Course c2 = mapper.getCourseById(15);
        Course c3 = mapper.getCourseById(16);
        Course c4 = mapper.getCourseById(17);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        session.commit();
    }
    //学生选课
    @Test
    public void test3_selectCourse(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        Student s1 = mapper.getStudentById(12);//11-13
        Course c1 = mapper.getCourseById(14);//14-17
        mapper.studentSelectCourse(s1, c1);

        session.commit();
    }
    @Test
    public void test4_selectS(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        List<Student> stus = mapper.getStudentByIdOnCondition(14);
        for(Student s : stus){
            System.out.println(s);
        }
        session.commit();
    }
    @Test
    public void test5_selectSC(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        Student student = mapper.getStudentByIdWithCourses(12);
        System.out.println(student);
        List<Course> courses = student.getCourses();
        for(Course c : courses){
            System.out.println(c);
        }

        session.commit();
    }
    @Test
    public void test6_selectSAll(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

        List<Student> students = mapper.getStudentWithCourses();
        for(Student s : students){
            System.out.println(s);
            for(Course c : s.getCourses()){
                System.out.println(c);
            }
        }
        session.commit();
    }
}
