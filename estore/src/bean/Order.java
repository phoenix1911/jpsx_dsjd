package bean;

import java.util.Date;

/**
 * Created by Tjl on 2018/8/31 8:52.
 */
public class Order {
    private int id;
    private int userid;
    private int addressid;
    private Double total;
    private Date date;
    private int state;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userid=" + userid +
                ", addressid=" + addressid +
                ", total=" + total +
                ", date=" + date +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Order() {
    }

    public Order(int id, int userid, int addressid, Double total, Date date, int state) {
        this.id = id;
        this.userid = userid;
        this.addressid = addressid;
        this.total = total;
        this.date = date;
        this.state = state;
    }
}
