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
        List<Book> books =null;
        BookDaoMapper mapper =mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(BookDaoMapper.class);
        List<Orderline> orderlineList =null;
        int orderId;
        List<Order> os;
        Address address;
        OrderInfo orderInfo;

        for (Order order:orders) {
            orderId = order.getId();
            os = orderlineService.selectALlOrderByID(orderId);
            address= orderlineService.selectAddressByID(order.getAddressid());
            //订单编号
            orderlineList = orderlineService.selectALlOrderlineByID(orderId);

            books = new ArrayList<>();


            for (Orderline orderline: orderlineList) {
                int bookid = orderline.getBookid();
                Book book = mapper.selectBookById(bookid);
                books.add(book);
            }

             orderInfo= new OrderInfo(orderId, address, order, orderlineList,books);

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
