package bean;

import java.util.List;

/**
 * Created by Tjl on 2018/9/4 16:08.
 */
public class OrderInfo {
    private int orderid;
    private Address address;
    private Order orders;
    private List<Orderline> orderlines;
    private List<Book> books;

    public OrderInfo(int orderid, Address address, Order orders, List<Orderline> orderlines, List<Book> books) {
        this.orderid = orderid;
        this.address = address;
        this.orders = orders;
        this.orderlines = orderlines;
        this.books = books;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderid=" + orderid +
                ", address=" + address +
                ", orders=" + orders +
                ", orderlines=" + orderlines +
                ", books=" + books +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public OrderInfo() {
    }
}
