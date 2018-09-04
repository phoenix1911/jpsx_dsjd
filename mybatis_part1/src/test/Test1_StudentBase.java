package test;

import mappers.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.PhoneNumber;
import pojo.Student;
import utils.MySqlSessionFactoryUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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

            Student student = new Student(999, "九九", "123@qq.com", new Date());
            mapper.insertStudent(student);
            session.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2_findStudentById() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = sqlSessionFactory.openSession();
            //通过sqlsession动态获取映射接口的实现类对象
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            //调用dao层方法
            Student student = mapper.findStudentById(98);
            System.out.println(student);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2_findAllStudent(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = sqlSessionFactory.openSession();
            //通过sqlsession动态获取映射接口的实现类对象
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            //调用dao层方法
            List<Student> allStudents = mapper.findAllStudents();
            System.out.println(allStudents);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }@Test
    /*
    测试 MySqlSessionFactoryUtil
     */
    public void test3_findAllStudent(){
        try {
//          InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession session = sqlSessionFactory.openSession();
            SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
            //通过sqlsession动态获取映射接口的实现类对象
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            //调用dao层方法
            List<Student> allStudents = mapper.findAllStudents();
            System.out.println(allStudents);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    测试自定义类型处理器_添加
     */
    @Test
        public void test4_typeHandler(){
            SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);

            PhoneNumber phone = new PhoneNumber("100", "101", "102");
            Student student = new Student(998, "withphone", "12@qq.com", new Date(), phone);

        mapper.insertStudentWithPhone(student);

        session.commit();
    }

    /*
    测试自定义类型处理器_查询
     */
    @Test
    public void test5_typeHandler(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);


        Student studentById = mapper.findStudentWithPhoneById(97);
        System.out.println(studentById);

        session.commit();
    }
}
