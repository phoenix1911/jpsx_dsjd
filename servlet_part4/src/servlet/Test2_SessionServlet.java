package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tjl on 2018/8/20 9:46.
 */
public class Test2_SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session范围传递数据
        //会话的开启:第一次调用request.getSession() 30min
        //会话的对象:HttpSession对象
        //会话的结束:超时:两次请求间隔30min


        //1.怎么获取session对象:request.getSession();
        HttpSession session = req.getSession();

        System.out.println("第一次获取的session : "+session.getId());

        //2.添加/替换/移除值
        session.setAttribute("name","tom");
        session.setAttribute("name2","tim");
        session.setAttribute("user",new User());
        session.setAttribute("list",new ArrayList<>());

        session.setAttribute("name","toms");

        session.removeAttribute("name2");

        System.out.println(session.getAttribute("name"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
