package test;

import mappers.One2OneMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import utils.MySqlSessionFactoryUtil;

/**
 * Created by Tjl on 2018/8/27 15:35.
 * 测试1对一映射
 */
public class Test3_One2OneMapper {
    @Test
    public void demo1_findStudentWithAddress() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        One2OneMapper mapper = session.getMapper(One2OneMapper.class);
        Student studentByIdWithAddress = mapper.findStudentByIdWithAddress(1);
        System.out.println(studentByIdWithAddress);
        System.out.println(studentByIdWithAddress.getAddress());

        session.commit();
    }

}
