package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by Tjl on 2018/8/20 15:38.
 * cookie的获取
 */
public class Test6_GetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        HttpSession session = req.getSession();

        PrintWriter writer = resp.getWriter();
        //获取所有cookie[k-v]
        //请求会携带"当前路径以及祖先路径下的cookie"
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c: cookies) {
                writer.println(c.getName()+" : "+ URLDecoder.decode(c.getValue(),"UTF-8"));
                //删除username这个cookie
                if(c.getName().equals("username"))
                    c.setMaxAge(0);
                    resp.addCookie(c);
            }
        }
        /*
        删除cookie 需要考虑路径
         */
        //删除cookie:再写一个同样key,同样path的cookie,时间设置为0
        Cookie delPwd = new Cookie("password", "");
        delPwd.setMaxAge(0);
        resp.addCookie(delPwd);


        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
