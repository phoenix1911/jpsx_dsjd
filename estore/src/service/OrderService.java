package service;

import bean.Order;

import java.util.Date;

/**
 * Created by Tjl on 2018/9/3 21:25.
 */
public interface OrderService {
    void insertOrder(Order order);

    int selectOrderById(Date date);

    int  selectSEQ_Order();
}
