package web.servlet.order;

import bean.Address;
import bean.ShopcartLine;
import service.AddressService;
import service.serviceImpl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Tjl on 2018/9/3 16:19.
 */
@WebServlet("/order.servlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddressService addressService = new AddressServiceImpl();
        List<Address> addresses = addressService.findallAddress();
        System.out.println(addresses);
        HttpSession session = req.getSession();
        session.setAttribute("addresses",addresses);
        req.getRequestDispatcher("home/order.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
