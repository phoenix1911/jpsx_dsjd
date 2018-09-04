package web.servlet.address;

import bean.User;
import service.AddressService;
import service.serviceImpl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/9/3 18:56.
 */
@WebServlet("/insertAddress.servlet")
public class insertAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int userid = user.getId();

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String info = req.getParameter("info");

        System.out.println(userid+name+phone+info);

        AddressService addressService = new AddressServiceImpl();
        addressService.insertAddress(userid,name,phone,info);
        req.getRequestDispatcher("order.servlet").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
