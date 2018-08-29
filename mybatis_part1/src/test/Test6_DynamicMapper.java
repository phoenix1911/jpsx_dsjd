package test;

import Many2Many.Course;
import mappers.DynamicMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MySqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tjl on 2018/8/28 15:03.
 */
public class Test6_DynamicMapper {
    @Test  //ok
    public void test1_DynamicSelect() {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        DynamicMapper mapper = session.getMapper(DynamicMapper.class);
        //将要使用的条件与值存于map中
        Map<String, Object> map = new HashMap<>();
        //if 设置参数/条件
        map.put("tutorId", 1);
        map.put("name","%Java%");//第二个条件
        //choose

        List<Course> courses = mapper.searchCourses(map);
        System.out.println(courses);
    }

}
