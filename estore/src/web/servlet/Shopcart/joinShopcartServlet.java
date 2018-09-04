package web.servlet.Shopcart;

import bean.Book;
import bean.ShopcartLine;
import service.BookService;
import service.serviceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tjl on 2018/9/1 14:29.
 */
@WebServlet("/joinServlet.servlet")
public class joinShopcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取
        String bookid = req.getParameter("id");
        String num = req.getParameter("num");
        System.out.println(bookid+"+++"+num);
//         获取购物车对象
        HttpSession session = req.getSession();
        Map<Integer, ShopcartLine> shopcart = (Map<Integer, ShopcartLine>) session.getAttribute("shopcart");
        //获取book
        BookService bookService = new BookServiceImpl();
        Book book = bookService.selectBookById(Integer.parseInt(bookid));
        //添加购物车
        shopcart.put(Integer.parseInt(bookid), new ShopcartLine(book,Integer.parseInt(num)));
//        更新session
        session.setAttribute("shopcart",shopcart);
        req.getRequestDispatcher("shopcart.servlet").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
