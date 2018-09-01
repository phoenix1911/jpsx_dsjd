package bean;

/**
 * Created by Tjl on 2018/8/31 8:47.
 */
public class Orderline {
    private int id;
    private int bookid;
    private int orderid;
    private int onumber;

    @Override
    public String toString() {
        return "Orderline{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", orderid=" + orderid +
                ", onumber=" + onumber +
                '}';
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
