package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/21 8:19.
 * 测试Url重写
 */
public class Test7_CookieUrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test7接收到请求");
        HttpSession session = req.getSession();
        System.out.println("JSESSIONID"+ session.getId());

        //获取请求中的cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c:cookies){
                System.out.println("请求中的cookie"+c.getName()+" : "+c.getValue());

            }
        }


        //URL重写
        //设置编码
        resp.setCharacterEncoding("utf-8");
        //获取输出流
        resp.setContentType("text/html;charset = utf-8");
        PrintWriter pw = resp.getWriter();
        String path = "UC.servlet";
        pw.print("<html><head><title>url重写</title></head><body>");
        //重写URL
        //禁用cookie会在超链接上拼接JSESSIONID
        //没有禁用就不会
        //页面中有一个超链接
        pw.print("<a href = '"+resp.encodeURL(path)+"'>是否有JSESSIONID</a>");
        pw.print("<body></html>");
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
