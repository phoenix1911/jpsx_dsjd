package Many2Many;

import pojo.Address;
import pojo.Student;

import java.util.List;

/**
 * Created by Tjl on 2018/8/27 15:33.
 */
public interface Many2ManyMapper {

    //插入student数据
    public void insertStudent(Student student);
    //插入course数据
    public void insertCourse(Course course);
    //通过id查询学生
    public Student getStudentById(Integer id);
    //通过id查询课程
    public Course getCourseById(Integer id);

    //学生x选课y
    public void studentSelectCourse(Student student, Course course);
    //查询比指定id值小的学生信息
    public List<Student> getStudentByIdOnCondition(Integer id);
    //查询student级联查询出所选的course并且组装成完整的对象
    public Student getStudentByIdWithCourses(Integer id);


}
