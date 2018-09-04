package mappers;

import pojo.Student;

import java.util.*;

/**
 * Created by Tjl on 2018/8/27 9:55.
 */
//映射文件[单表操作]
public interface BaseMapper {
    //添加一个学生对象
    public void insertStudent(Student student);

    //添加一个学生对象，主键自增
    public void insertStudent_autoId(Student student);//直接使用序列方法

    //添加一个学生对象，主键自增，不使用标签,直接获取序列的下一个值
    public void insertStudent_autoId2(Student student);

    //更新一个学生信息
    public void updateStudent(Student student);

    //删除一个学生信息
    public void deleteStudentById(Integer id);

    //查询一个学生信息
    public Student findStudentById(Integer id);

    //查询所有学生信息，封装为list集合
    public List<Student> findAllStudents();

    //查询所有学生信息，不用列起别名，使用自己确定映射规则
    public List<Student> findAllStudents_resultMap();

    //查询一个学生信息，学生信息使用key-value的形式封装成map集合
    public Map<String, Object> findStudentById_Map(Integer id);

    //查询所有学生信息，每个学生信息使用key-value的形式封装成map集合
    public List<Map<String, Object>> findAllStudents_Map();

    //查询所有学生信息，学生信息封装为Student后，存于set中:hashSet
    public Set<Student> findAllStudents_Set();

    //查询所有学生信息，学生信息封装为Student后，存于set中:SortedSet:要求排序
    public SortedSet<Student> findAllStudents_SortedSet();

    //查询所有学生的姓名，将姓名存放到list集合中
    public List<String> findAllName_list();

    //查询所有的记录数量
    public int findCount_int();

    //按照email分组，查询每组学生的数量
    public List<Integer> findCount_group();

    //按照指定的字段名分组，查询每组学生的数量
    public List<Integer> findCount_group2(HashMap<String, String> columnName);

    public List<Integer> findCount_group3(String columnName);

    public Student findStudentByName(String name);
}
