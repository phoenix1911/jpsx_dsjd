package test;

import mappers.DynamicMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Course;
import utils.MySqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.Map;

public class Test6_DynamicMapper {

    @Test
    public void test1_insertS()  {
        SqlSession session = MySqlSessionFactoryUtil.openSqlSession();
        DynamicMapper mapper = session.getMapper(DynamicMapper.class);
        //将要使用的条件与值存于map中
        Map<String, Object> searchmap = new HashMap<String, Object>();
        //if设置参数/条件
		/*searchmap.put("tutorId", 1);
		searchmap.put("name", "%Java%");//第二个条件
		searchmap.put("description", "%Java%");//第三个条件
		searchmap.put("start_date",new SimpleDateFormat("yyyy-MM-dd").parse("2014-10-20"));//第四个条件
		searchmap.put("end_date", new Date());//第五个条件
*/
        //choose
//		searchmap.put("searchBy", "tutor");
//		searchmap.put("searchValue", 1);
//		searchmap.put("searchBy", "courseName");
//		searchmap.put("searchValue", "%Java%");

        //where trim
//		searchmap.put("tutorId", 1);
//		searchmap.put("name", "%Java%");
//		searchmap.put("endDate", new Date());

        //foreach
//		ArrayList<Integer> tutorIds = new ArrayList<Integer>();
//		tutorIds.add(1);
//		tutorIds.add(2);
//		tutorIds.add(3);
//		searchmap.put("tutorIds", tutorIds);

//		List<Course> courses = mapper.searchCourses(searchmap);
//		for(int i=0;i<courses.size();i++){
//			System.out.println(courses.get(i));
//		}

        //set
        Course course = new Course();
        course.setCourseId(1);
        course.setName("Java");
        course.setDescription("30天....");
        mapper.updateCourses(course);

        session.commit();
    }

}
