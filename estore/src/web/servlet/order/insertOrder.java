package web.servlet.order;

import bean.*;
import service.OrderService;
import service.OrderlineService;
import service.serviceImpl.OrderServiceImpl;
import service.serviceImpl.OrderlineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tjl on 2018/9/3 20:04.
 */
@WebServlet("/insertOrder.servlet")
public class insertOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

//        添加到order表
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        String  addressid =req.getParameter("addressid");
        String  totals =req.getParameter("total");
        double total = Double.parseDouble(totals);
        Date date = new Date();

        OrderService orderService = new OrderServiceImpl();
        int id = orderService.selectSEQ_Order();
        Order order = new Order(id,userId, Integer.parseInt(addressid),total, date, 1);
        orderService.insertOrder(order);

        System.out.println(id+"*************************");


        //添加到orderline表
        Map<Integer, ShopcartLine> shopcart = (Map<Integer, ShopcartLine>) session.getAttribute("shopcart");
        Set<Map.Entry<Integer, ShopcartLine>> entries = shopcart.entrySet();
        for (Map.Entry<Integer, ShopcartLine> entry :entries) {
            Integer bookid = entry.getKey();
            ShopcartLine shopcartLine = entry.getValue();
            System.out.println(bookid+"  "+shopcartLine.getBook()+"   "+shopcartLine.getNumber());
            OrderlineService orderlineService = new OrderlineServiceImpl();
            Orderline orderline = new Orderline(bookid, id, shopcartLine.getNumber());
            orderlineService.insertOrderLine(orderline);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println(entries);

        req.getRequestDispatcher("showOrderline.servlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
