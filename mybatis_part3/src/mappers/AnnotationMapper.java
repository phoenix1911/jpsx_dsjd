package mappers;

import org.apache.ibatis.annotations.*;
import pojo.Address;
import pojo.Course;
import pojo.Tutor;
import pojo.annotation.Person;

import java.util.List;

/**
 * Created by Tjl on 2018/8/29 16:12.
 */
public interface AnnotationMapper {

    @Insert("insert into person(pid,name,age) values(#{id},#{name},#{age})")
    public void insertPerson(Person person);

    @Insert("insert into person(pid,name,age) values(#{id},#{name},#{age})")
    @SelectKey(statement = "select my_seq.nextval from dual",keyProperty="id",resultType = Integer.class,before = true)
    public void insertPersonAutoId(Person person);

    @Update("update person set name =#{name},age=#{age} where pid =#{id}")
    public void updatePerson(Person person);

    @Delete("delete from person where pid = #{id}")
    public void deletePersonById(Integer id);

    @Select("select pid as id,name,age from person where pid=#{id}")
    public Person findPersonById(Integer id);

    @Select("select * from person")
    @Results({
            @Result(id=true,property = "id",column = "pid")
    })
    public List<Person> findAllPerson();

    @Select("select * from person")
    @Results({
            @Result(id=true,property = "id",column = "pid")
    })
    public List<Person> findAllPerson_ResultMap();

    @Select("Select * from person")
//    @ResultMap("com.briup.zb.PersonResult")
    public List<Person> findAllPerson_ResultMap_XML();

    public Address findAddressById(Integer addrId);

    public pojo.Student findStudentByIdWithAddress(Integer id);

    public pojo.Student findStudentByIdWithAddress_resultMap(Integer id);

    public List<Course> findCoursesByTutorId(Integer tutor_id);

    public Tutor findTutorById(int tutorId);

    public Tutor findTutorById_resultMap(int tutorId);
}
