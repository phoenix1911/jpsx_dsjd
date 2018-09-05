package web.servlet.Shopcart;

import bean.ShopcartLine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tjl on 2018/9/5 12:22.
 */
@WebServlet("/deleteRowFromShopcart.servlet")
public class deleteRowFromShopcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookid = req.getParameter("bookid");
        HttpSession session = req.getSession();
        Map<Integer, ShopcartLine> shopcart = (Map<Integer, ShopcartLine>) session.getAttribute("shopcart");
        shopcart.remove(Integer.parseInt(bookid));
        session.setAttribute("shopcart",shopcart);
        req.getRequestDispatcher("shopcart.servlet").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
