package mappers;

import pojo.Address;
import pojo.Student;
import pojo.Tutor;

/**
 * Created by Tjl on 2018/8/27 15:33.
 */
public interface One2ManyMapper {

    //查询课程,级联查询出对应的课程集合与地址对象
    public Tutor findTutorByIdWithCoursesA(int tutorId);

}
