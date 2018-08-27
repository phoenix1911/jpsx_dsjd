package test;

import mappers.BaseMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.PhoneNumber;
import pojo.Student;
import utils.MySqlSessionFactoryUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Tjl on 2018/8/27 9:58.
 */
public class Test2_BaseMapper {

    @Test
    public void demo1_insert() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        PhoneNumber phoneNumber = new PhoneNumber("110-120-119");
        Student student = new Student(101, "base_demo1", "111@qq.com", new Date(), phoneNumber);
        Student student2 = new Student(102, "base_demo1", "111@qq.com", new Date(), phoneNumber);
        //4.1获取映射杰奎实现类对象的方式
        mapper.insertStudent(student);
        //4.2直接通过sqlSession的方法
        session.insert("mappers.BaseMapper.insertStudent", student2);
        session.commit();
    }

    @Test
    public void demo2and3_insert_auto() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        PhoneNumber phoneNumber = new PhoneNumber("110-120-119");
        Student student = new Student(101, "base_demo1", "111@qq.com", new Date(), phoneNumber);
        Student student2 = new Student(102, "base_demo1", "111@qq.com", new Date(), phoneNumber);

        mapper.insertStudent_autoId(student);
        mapper.insertStudent_autoId2(student2);

        System.out.println(student);
        System.out.println(student2);

        session.commit();
    }

    @Test
    public void demo4_update() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //2.获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        PhoneNumber phoneNumber = new PhoneNumber("110-120-119");
        Student student = new Student(9, "base_demo4", "999@qq.com", new Date(), phoneNumber);
        Student student2 = new Student(102, "base_demo4", "102@qq.com", new Date(), phoneNumber);

        mapper.updateStudent(student);
        session.update("mappers.BaseMapper.updateStudent", student2);


        session.commit();
    }

    @Test
    public void demo5_delete() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //2.获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        mapper.deleteStudentById(102);
        session.delete("mappers.BaseMapper.deleteStudentById", 103);


        session.commit();
    }
    @Test
    public void demo6_selectById() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //2.获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        Student studentById = mapper.findStudentById(99);
        System.out.println("findStudentById: "+studentById);
        Object o = session.selectOne("mappers.BaseMapper.findStudentById", 97);
        System.out.println("findStudentById: "+o);


        session.commit();
    }

    @Test
    public void demo7_findAllStudent() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //2.获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        List<Student> allStudents = mapper.findAllStudents();
        System.out.println("findallstudent: " + allStudents);
        Object o = session.selectOne("mappers.BaseMapper.findAllStudents");
        System.out.println(o);
        session.commit();
    }

    @Test
    public void demo8_select3() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //2.获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        List<Student> allStudents_resultMap = mapper.findAllStudents_resultMap();
        System.out.println(allStudents_resultMap);
        List<Object> objects = session.selectList("mappers.BaseMapper.findAllStudents_resultMap()");
        System.out.println(objects);
        session.commit();
    }

    @Test
    public void demo9_findStudentById_Map() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        Map<String, Object> studentById_map = mapper.findStudentById_Map(201);
        System.out.println(studentById_map);
        session.commit();

    }


    @Test
    public void demo10_select5() {
        //1.获取sqlSession
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        //2.获取映射接口对应的实现类对象
        BaseMapper mapper = session.getMapper(BaseMapper.class);
        //3.执行方法--sql
        List<Map<String, Object>> allStudents_map = mapper.findAllStudents_Map();
        for (Map<String, Object> map :allStudents_map) {
            System.out.println(map);

        }


        session.commit();
    }
}