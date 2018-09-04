package service.serviceImpl;

import bean.Order;
import common.util.SqlSessionFactoryUtil;
import dao.OrderDaoMapper;
import org.junit.Test;
import service.OrderService;

import java.util.Date;

/**
 * Created by Tjl on 2018/9/3 21:26.
 */
public class OrderServiceImpl implements OrderService {
    private OrderDaoMapper orderDaoMapper;
    {
        orderDaoMapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(OrderDaoMapper.class);
    }

    @Override
    public void insertOrder(Order order) {
        orderDaoMapper.insertOrder(order);

    }

    @Override
    public int selectOrderById(Date date) {
        return orderDaoMapper.selectOrderIdByDate(date);
    }

    @Override
    public int selectSEQ_Order() {
        int i = orderDaoMapper.selectSEQ_Order();
        System.out.println(i);
        return i;
    }
}
