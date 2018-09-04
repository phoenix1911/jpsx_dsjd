package web.servlet.address;

import service.AddressService;
import service.serviceImpl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/9/3 17:50.
 */
@WebServlet("/deleteAddress.servlet")
public class deleteAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        AddressService addressService = new AddressServiceImpl();
        addressService.deleteAddress(Integer.parseInt(address));
        req.getRequestDispatcher("order.servlet").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
