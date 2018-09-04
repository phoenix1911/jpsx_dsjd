package mappers;

import pojo.Address;
import pojo.Student;

/**
 * Created by Tjl on 2018/8/27 15:33.
 */
public interface One2OneMapper {

    //查询学生信息，要求携带地址
    public Student findStudentByIdWithAddress(Integer id);

    public void insertAddress(Address address);

    public void insertStudent(Student student);

}
