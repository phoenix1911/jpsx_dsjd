package mappers;

import Many2Many.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by Tjl on 2018/8/28 16:05.
 */
public interface DynamicMapper {
    //根据不同条件 查询 符合的课程信息
    List<Course> searchCourses(Map<String,Object> map);

    //更新课程信息
    public void update(Course course);
}
