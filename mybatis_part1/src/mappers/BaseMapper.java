package mappers;

import pojo.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Tjl on 2018/8/27 9:55.
 */
public interface BaseMapper {
    //添加一个学生对象
    public void insertStudent(Student student);

    //添加一个学生对象,主键自增
    public void insertStudent_autoId(Student student);//直接使用序列方法

    //添加一个学生对象,主键自增,直接使用序列的下一个值
    public void insertStudent_autoId2(Student student);

    //更新一个学生信息
    public void updateStudent(Student student);

    //删除一个学生信息
    public void deleteStudentById(Integer id);

    //查询一个学生信息
    public Student findStudentById(Integer id);

    public List<Student> findAllStudents();


    //丰富的结果集封装
    public List<Student> findAllStudents_resultMap();

    public Map<String, Object> findStudentById_Map(Integer id);

    public List<Map<String, Object>> findAllStudents_Map();

    public Set<Student> findAllStudents_Set();

    public SortedSet<Student> findAllStudents_SortedSet();

    public List<String> findAllName_list();

    public int findCount_int();
// 分组
    public List<Integer> findCount_group();

    public List<Integer> findCount_group2(String columnName);

    public List<Student> findStudentByName(String name);
}
