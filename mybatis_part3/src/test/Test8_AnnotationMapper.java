package test;

import mappers.AnnotationMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.annotation.Person;
import util.MySqlSessionFactoryUtil;

import java.util.List;

/**
 * Created by Tjl on 2018/8/29 16:17.
 */
public class Test8_AnnotationMapper {

    //注解:insertS ok
    @Test
    public void demo1_insertS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        mapper.insertPerson(zs);
        session.commit();
    }
    //注解:insertS ok
    @Test
    public void demo2_insertSAuto() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        mapper.insertPersonAutoId(zs);
        session.commit();
    }

    //注解:update ok
    @Test
    public void demo3_UpdateS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "ls", 12);
        mapper.updatePerson(zs);
        session.commit();
    }

    //注解:delete ok
    @Test
    public void demo4_DeleteS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        mapper.deletePersonById(1);
        session.commit();
    }

    //注解:单一select ok
    @Test
    public void demo5_selectS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        mapper.findPersonById(1);
        session.commit();
    }

    //注解:select * ok
    @Test
    public void demo6_selectAllS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        List<Person> allPerson = mapper.findAllPerson();
        System.out.println(allPerson);
        session.commit();
    }

    //注解:select * ok
    @Test
    public void demo7_selectAllS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        List<Person> allPerson_resultMap = mapper.findAllPerson_ResultMap();
        System.out.println(allPerson_resultMap);

        session.commit();
    }

    @Test //error
    public void demo8_selectAllS() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
        Person zs = new Person(1, "zs", 12);
        List<Person> allPerson = mapper.findAllPerson_ResultMap_XML();
        System.out.println(allPerson);
        session.commit();
    }


}
