package web.servlet.list;

import bean.Book;
import service.BookService;
import service.serviceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Tjl on 2018/8/31 15:01.
 */
@WebServlet("/list.servlet")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取分类id
        String categoryid = req.getParameter("categoryid");
        //获取分类下所有书籍
        BookService bookService = new BookServiceImpl();
        List<Book> books = bookService.selectBooksByCategory(Integer.parseInt(categoryid));
        System.out.println(books);
        //发送给list.jsp
        HttpSession session = req.getSession();
        session.setAttribute("books",books);
        req.getRequestDispatcher("home/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
