package servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tjl on 2018/8/23 14:07.
 */
public class Test5_JSTL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过一些处理,获取到许多学生数据,封装成集合");
        Student s1 = new Student("zs",14,"F");
        Student s2 = new Student("gs",14,"F");
        Student s3 = new Student("er",16,"F");
        Student s4 = new Student("th",18,"F");
        Student s5 = new Student("vn",10,"F");
        Student s6 = new Student("es",12,"F");
        //集合
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);

        Map<String, Student> map = new HashMap<>();
        map.put("s1", s1);
        map.put("s2", s2);
        map.put("s3", s3);
        map.put("s4", s4);
        map.put("s5", s5);
        map.put("s6", s6);
        req.setAttribute("map",map);

        req.setAttribute("studentlist",studentList);
        req.getRequestDispatcher("/jsp/Test5_JSTL.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
