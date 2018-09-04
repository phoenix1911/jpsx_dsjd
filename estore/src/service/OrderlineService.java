package service;

import bean.Address;
import bean.Order;
import bean.Orderline;

import java.util.List;

/**
 * Created by Tjl on 2018/9/3 21:25.
 */
public interface OrderlineService {

    List<Orderline> getAllOrderline();

    void insertOrderLine(Orderline orderline);

    List<Order> selectAllOrder();

    List<Order> selectALlOrderByID(int orderid);

    Address selectAddressByID(int addressId);

    List<Orderline> selectALlOrderlineByID(int orderId);
}
