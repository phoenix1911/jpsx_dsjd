package web.servlet.orderline;

import bean.*;
import common.util.SqlSessionFactoryUtil;
import dao.BookDaoMapper;
import service.OrderlineService;
import service.serviceImpl.OrderlineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tjl on 2018/9/4 14:53.
 */
@WebServlet("/showOrderline.servlet")
public class showOrderline extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderlineService orderlineService = new OrderlineServiceImpl();
        //1.获取所有的订单编号

        List<OrderInfo> orderinfos = new ArrayList<>();

        List<Order> orders = orderlineService.selectAllOrder();
        for (Order order:orders) {
            int orderId = order.getId();
            List<Order> os = orderlineService.selectALlOrderByID(orderId);
            System.out.println(os+"********2");
            Address address = orderlineService.selectAddressByID(order.getAddressid());
            System.out.println(address+"********3");

            //订单编号
            List<Orderline> orderlineList = orderlineService.selectALlOrderlineByID(orderId);
            List<Book> books = new ArrayList<>();

            List<Integer> bookids = new ArrayList<>();
            for (Orderline orderline: orderlineList) {
                int bookid = orderline.getBookid();
                bookids.add(bookid);
            }
            System.out.println(bookids);
            System.out.println("执行完了");
            BookDaoMapper mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(BookDaoMapper.class);
            for (Integer i: bookids) {
                Book book = mapper.selectBookById(i);
                books.add(book);
            }







            OrderInfo orderInfo = new OrderInfo(orderId, address, order, orderlineList,books);

            orderinfos.add(orderInfo);

        }
        HttpSession session = req.getSession();
        session.setAttribute("orderinfos",orderinfos);
        req.getRequestDispatcher("home/myorder.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
