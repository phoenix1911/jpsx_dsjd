package mappers;

import pojo.Student;

import java.util.List;

/*
 * 映射接口与映射文件对应关系：全类名==<mapper namespace="映射接口的全类名">
 * 					         方法==<insert/select/delete/update id="方法名" >
 * sqlsession动态生成映射接口的实现类对象，执行映射接口定义的方法，其实是执行映射文件中声明的sql语句
 * */
public interface StudentMapper {
    void insertStudent(Student student);

    List<Student> findAllStudents();

    Student findStudentById(Integer id);
    //void updateStudent(Student student);
    //void deleteStudentById(Integer id);
    //void insertStudentWithPhone(Student student);
    //Student findStudentWithPhoneById(Integer id);
}
