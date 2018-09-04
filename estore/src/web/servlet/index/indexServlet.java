package web.servlet.index;

import bean.Book;
import bean.Category;
import bean.ShopcartLine;
import service.BookService;
import service.CategoryService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tjl on 2018/8/31 9:49.
 */
@WebServlet("/index.servlet")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        //获取所有分类及分类前两本书
        List<Category> allCategory = categoryService.findAllCategory();
        //获取前5分类
        List<Category> row5Category = categoryService.find5rowCategory();

        BookService bookService = new BookServiceImpl();
        //获取推荐书籍
        List<Book> books1 = bookService.selectRecommendedBooks();
        //获取最高销量3本
        List<Book> books2 = bookService.selectBestSeller3Books();

        //初始化购物车
        Map<Integer, ShopcartLine> shopcart= new HashMap();
        //测试数据
//        shopcart.put(1,new ShopcartLine(books2.get(0),3));



        HttpSession session = req.getSession();
        session.setAttribute("allCategory", allCategory);
        session.setAttribute("row5Categoty", row5Category);
        session.setAttribute("recommendedBooks",books1);
        session.setAttribute("BestSeller3Books",books2);
        session.setAttribute("shopcart",shopcart);
        req.getRequestDispatcher("home/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
