package web.servlet.Shopcart;

/**
 * Created by Tjl on 2018/9/1 8:40.
 */

/**
 * 1.获取参数id num
 * 2.根据id查询出对应得book对象
 * 3.获取session
 * 4.从session中取出购物车,如果取不出来,新建一个购物车对象
 * 5.根据bookid,从购物车中找有没有对应的购物车项,
 * 6.如果有,取出购物车项中的num,加num
 * 7.如果没有,新建一个购物车项,数量的默认值为num
 * 8.更新购物车,重新放购物车项
 * 9.更新session中的购物车
 * 10.跳转到shopcart.jsp
 */
public class ShopcartServlet {

}
