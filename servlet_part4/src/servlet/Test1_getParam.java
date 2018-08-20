package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/20 9:07.
 */
public class Test1_getParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求范围中的参数
        //1.请求对象的获取:参数中有
        //2.调用方法
        System.out.println("request范围: name"+req.getAttribute("name"));
        System.out.println("request范围: name2"+req.getAttribute("name2"));
        System.out.println("request范围: user"+req.getAttribute("user"));
        System.out.println("request范围: list"+req.getAttribute("list"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
