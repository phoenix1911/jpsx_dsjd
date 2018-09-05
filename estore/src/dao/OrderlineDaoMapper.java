package dao;

import bean.Address;
import bean.Order;
import bean.Orderline;

import java.util.List;

/**
 * Created by Tjl on 2018/9/4 13:43.
 */
public interface OrderlineDaoMapper {
    void insertOrderLineAutoId(Orderline orderline);

    List<Order> selectAllOrder();

    List<Order> selectALlOrderByID(int orderid);

    List<Order> selectOrderByUserID(int userid);

    Address selectAddressByID(int addressid);

    List<Orderline> selectALlOrderlineByID(int orderId);
}
