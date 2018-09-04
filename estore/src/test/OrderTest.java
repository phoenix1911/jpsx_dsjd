package test;

import bean.Order;
import bean.Orderline;
import common.util.SqlSessionFactoryUtil;
import dao.OrderlineDaoMapper;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tjl on 2018/9/4 15:01.
 */
public class OrderTest {
    @Test
    public void test1() {
        OrderlineDaoMapper mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(OrderlineDaoMapper.class);
        List<Order> orders = mapper.selectAllOrder();
        System.out.println(orders);
    }

}
