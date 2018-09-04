package bean;

/**
 * Created by Tjl on 2018/8/31 8:51.
 */
public class Address {
    private int id;
    private int userid;

    public Address(int userid, String name, String phone, String info) {
        this.userid = userid;
        this.name = name;
        this.phone = phone;
        this.info = info;
    }

    private String name;
    private String phone;
    private String info;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Address(int id, int userid, String name, String phone, String info) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.phone = phone;
        this.info = info;
    }

    public Address() {
    }
}
