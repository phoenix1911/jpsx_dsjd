package service.serviceImpl;

import bean.Address;
import bean.Order;
import bean.Orderline;
import common.util.SqlSessionFactoryUtil;
import dao.OrderlineDaoMapper;
import service.OrderlineService;

import java.util.List;

/**
 * Created by Tjl on 2018/9/3 21:29.
 */
public class OrderlineServiceImpl implements OrderlineService {
    private OrderlineDaoMapper orderlineDaoMapper;
    {
        orderlineDaoMapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(OrderlineDaoMapper.class);
    }


    @Override
    public List<Orderline> getAllOrderline() {
        return null;
    }



    @Override
    public void insertOrderLine(Orderline orderline) {
        orderlineDaoMapper.insertOrderLineAutoId(orderline);

    }

    @Override
    public List<Order> selectAllOrder() {
        return orderlineDaoMapper.selectAllOrder();
    }



    @Override
    public List<Order> selectALlOrderByID(int orderid) {
        return orderlineDaoMapper.selectALlOrderByID(orderid);
    }

    @Override
    public Address selectAddressByID(int addressId) {
        return orderlineDaoMapper.selectAddressByID(addressId);
    }

    @Override
    public List<Orderline> selectALlOrderlineByID(int orderId) {
        return orderlineDaoMapper.selectALlOrderlineByID(orderId);
    }
}
