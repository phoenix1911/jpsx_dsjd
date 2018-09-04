package mappers;


import Many2Many.Course;
import Many2Many.Student;

import java.util.List;

/**
 * Created by Tjl on 2018/8/27 15:33.
 */
public interface Many2ManyMapper {

    //插入student数据
    public void insertStudent(Many2Many.Student student);

    //插入course数据
    public void insertCourse(Many2Many.Course course);

    //通过id查询学生
    public Many2Many.Student getStudentById(Integer id);

    //通过id查询课程
    public Many2Many.Course getCourseById(Integer id);

    //学生x选课y
    public void studentSelectCourse(Many2Many.Student student, Many2Many.Course course);

    //查询比指定id值小的学生信息
    public List<Many2Many.Student> getStudentByIdOnCondition(Integer id);

    //查询student级联查询出所选的course并且组装成完整的对象
    public Student getStudentByIdWithCourses(Integer id);

    //所有学生信息
    public List<Many2Many.Student> getStudentWithCourses();

}
