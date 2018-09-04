package test;

import mappers.One2OneMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Address;
import pojo.PhoneNumber;
import pojo.Student;
import utils.MySqlSessionFactoryUtil;

import java.util.Date;

/**
 * Created by Tjl on 2018/8/27 15:35.
 * 测试1对一映射
 */
//ok
public class Test3_One2OneMapper {
    @Test
    public void test1_findStudentWithAddress(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        One2OneMapper mapper = session.getMapper(One2OneMapper.class);
        Student student = mapper.findStudentByIdWithAddress(2);
        System.out.println(student);
        System.out.println(student.getAddress());
        session.commit();
    }

    //ok
    @Test
    public void test2_insert(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        One2OneMapper mapper = session.getMapper(One2OneMapper.class);

        PhoneNumber phone = new PhoneNumber("100-101-102");
        Address address = new Address("test", "test", "test", "1235", "CH");
        Student student = new Student("zs", "zs@qq.com", new Date(), phone, address);

        //添加的先后顺序
        mapper.insertAddress(address);
        System.out.println(address);

        mapper.insertStudent(student);
        System.out.println(student);

        session.commit();
    }

}
