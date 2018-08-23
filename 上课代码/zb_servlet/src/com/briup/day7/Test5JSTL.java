package com.briup.day7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理：查找一些符合条件/全部的的学生数据
 */
public class Test5JSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test5JSTL() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("经过一些处理，获取到了很多学生数据，封装为集合");
		Student s1 = new Student("张三", 15, "F");
		Student s2 = new Student("李四", 16, "M");
		Student s3 = new Student("王五", 17, "F");
		Student s4 = new Student("赵六", 18, "M");
		Student s5 = new Student("钱七", 19, "F");
		//上边的数据，内存中创建的--注册上10个
		//集合
		List<Student> stusl = new ArrayList<Student>();
		stusl.add(s1);
		stusl.add(s2);
		stusl.add(s3);
		stusl.add(s4);
		stusl.add(s5);
		request.setAttribute("stusl", stusl);
		
		Set<Student> stuss = new HashSet<Student>(); 
		stuss.add(s1);
		stuss.add(s2);
		stuss.add(s3);
		stuss.add(s4);
		stuss.add(s5);
		request.setAttribute("stuss", stuss);
		
		Map<String, Student> stusm = new HashMap<String, Student>();
		stusm.put("s1", s1);
		stusm.put("s2", s2);
		stusm.put("s3", s3);
		stusm.put("s4", s4);
		stusm.put("s5", s5);
		request.setAttribute("stusm", stusm);
		
		
		//方式1:
		/*PrintWriter pw = response.getWriter();
		pw.print("<html><head></head><body>");
		pw.print("<table><tr><th>姓名</th><th>年龄</th><th>性别</th></tr>");
		for(Student s : stusl){
			pw.print("<tr>");
			pw.print("<td>"+s.getName()+"</td>");
			pw.print("<td>"+s.getAge()+"</td>");
			pw.print("<td>"+s.getGender()+"</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.print("</body></html>");*/
		request.getRequestDispatcher("/jsp_day2/test5_jstl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
