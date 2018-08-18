package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by Tjl on 2018/8/18 8:41.
 * 测试:请求参数的获取
 */
public class Test1_RequestParamter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到GET请求");
        //编码问题【路径，编码】
        //POST方式中文乱码
        req.setCharacterEncoding("utf-8");

        //1.获取单一key的参数名获取 对应的请求参数
        String sid = req.getParameter("sid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String time = req.getParameter("time");
        String hobby = req.getParameter("hobby");
        String address = req.getParameter("address");
        String self = req.getParameter("self");

        System.out.println("sid: "+sid);
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        System.out.println("time: "+time);
        System.out.println("hobby: "+hobby);
        System.out.println("address: "+address);
        System.out.println("self: "+self);

        System.out.println("2-------------------------");
        //2.相同key 对应不同value，根据一个key值获取所有匹配的参数值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        System.out.println("3---------------------------");
        //3.获取所有的参数的key值
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            System.out.println(key+": "+Arrays.toString(req.getParameterValues(key)));
        }

        System.out.println("4---------------------------");
        //4.获取所有的参数键值对key:参数键值对的键名，value:与之对应的所有参数值组成的字符串数组
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> paramKeys = parameterMap.keySet();
        for (String paramKey : paramKeys) {
            System.out.println(paramKey+" : "+Arrays.toString(req.getParameterValues(paramKey)));
        }


        PrintWriter writer = resp.getWriter();
        writer.println("requestparamter.servlet");
        writer.flush();
        writer.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到POST请求");
        doGet(req, resp);
    }
}
