package test;

import mappers.One2ManyMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Tutor;
import utils.MySqlSessionFactoryUtil;

/**
 * Created by Tjl on 2018/8/27 16:56.
 */
public class Test4_One2ManyMapper {
    @Test
    public void test1_findStudentWithAddress(){
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        One2ManyMapper mapper = session.getMapper(One2ManyMapper.class);
        Tutor tutorByIdWithCoursesA = mapper.findTutorByIdWithCoursesA(1);
        System.out.println(tutorByIdWithCoursesA);
        System.out.println(tutorByIdWithCoursesA.getCourses());
        System.out.println(tutorByIdWithCoursesA.getAddress());

        session.commit();
    }

}
