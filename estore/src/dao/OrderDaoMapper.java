package dao;

import bean.Order;
import java.util.Date;

/**
 * Created by Tjl on 2018/9/4 12:45.
 */
public interface OrderDaoMapper {
    public void insertOrder(Order order);

    int selectOrderIdByDate(Date date);

    int selectSEQ_Order();
}
