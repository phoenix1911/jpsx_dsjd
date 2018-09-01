package web.servlet.book;

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

/**
 * Created by Tjl on 2018/8/31 16:38.
 */
@WebServlet("/book.servlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取书籍id
        String bookid = req.getParameter("bookid");
        //获取book对象
        BookService bookService = new BookServiceImpl();
        Book book = bookService.selectBookById(Integer.parseInt(bookid));
        System.out.println(book);
        //先后台发送书籍
        HttpSession session = req.getSession();
        session.setAttribute("bookinfo",book);
        req.getRequestDispatcher("home/book.jsp").forward(req, resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
