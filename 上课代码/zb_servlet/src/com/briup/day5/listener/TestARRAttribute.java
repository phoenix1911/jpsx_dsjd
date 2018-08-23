package com.briup.day5.listener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 对域对象范围进行属性值的操作
 * */
public class TestARRAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestARRAttribute() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("成功执行TestARRAttribute");
		//请求范围内添加、移除、替换值
		/*request.setAttribute("namer", "zs");
		request.setAttribute("namer", "ls");
		request.removeAttribute("namer");*/
		
		//session范围添加、移除、替换值
//		HttpSession session = request.getSession();
//		session.setAttribute("names", "zs");
//		session.setAttribute("names", "ls");
//		session.removeAttribute("names");
		
		//application范围添加、移除、替换值
		/*ServletContext application = getServletContext();
		application.setAttribute("namea", "tom");
		application.setAttribute("namea", "tim");
		application.removeAttribute("namea");*/
		
		//session范围添加移除替换UserWithListener类型的对象
		HttpSession session = request.getSession();
//		session.setAttribute("user", "tom");
		session.setAttribute("users", new UserWithListener("zs", 15, "F"));
		session.setAttribute("users", new UserWithListener("ls", 17, "M"));
//		session.removeAttribute("user");
//		session.removeAttribute("users");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
