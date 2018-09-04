package web.servlet.Shopcart;

/**
 * Created by Tjl on 2018/9/1 8:40.
 */

import bean.ShopcartLine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1.获取参数id num
 * 2.根据id查询出对应得book对象
 * 3.获取session
 * 4.从session中取出购物车,如果取不出来,新建一个购物车对象
 * 5.根据bookid,从购物车中找有没有对应的购物车项,
 * 6.如果有,取出购物车项中的num,加num
 * 7.如果没有,新建一个购物车项,数量的默认值为num
 * 8.更新购物车,重新放购物车项
 * 9.更新session中的购物车
 * 10.跳转到shopcart.jsp
 */
@WebServlet("/shopcart.servlet")
public class ShopcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<Integer, ShopcartLine> shopcart = (Map<Integer, ShopcartLine>) session.getAttribute("shopcart");
        if (shopcart == null) {
            shopcart = new HashMap();

        }
        System.out.println(shopcart);
        Set<Map.Entry<Integer, ShopcartLine>> entries = shopcart.entrySet();
        for (Map.Entry<Integer,ShopcartLine> entry: entries) {
            System.out.println(entry.getKey()+"::"+entry.getValue());
        }
        req.getRequestDispatcher("home/shopcart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
