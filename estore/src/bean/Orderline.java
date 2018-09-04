package bean;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 8:47.
 */
public class Orderline {
    private int id;
    private int bookid;
    private int orderid;
    private int onumber;

    public Orderline(int bookid, int orderid, int onumber) {
        this.bookid = bookid;
        this.orderid = orderid;
        this.onumber = onumber;
    }

    private Address address;

    public Orderline(int bookid, int orderid, int onumber, Address address, List<Order> orders) {
        this.bookid = bookid;
        this.orderid = orderid;
        this.onumber = onumber;
        this.address = address;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Orderline{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", orderid=" + orderid +
                ", onumber=" + onumber +
                ", address=" + address +
                ", orders=" + orders +
                '}';
    }

    private List<Order> orders;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Orderline(int id, int bookid, int orderid, int onumber, Address address, List<Order> orders) {
        this.id = id;
        this.bookid = bookid;
        this.orderid = orderid;
        this.onumber = onumber;
        this.address = address;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getOnumber() {
        return onumber;
    }

    public void setOnumber(int onumber) {
        this.onumber = onumber;
    }

    public Orderline(int id, int bookid, int orderid, int onumber) {
        this.id = id;
        this.bookid = bookid;
        this.orderid = orderid;
        this.onumber = onumber;
    }

    public Orderline() {
    }
}
