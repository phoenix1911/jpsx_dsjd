package bean;

import java.util.Date;

/**
 * Created by Tjl on 2018/8/30 9:33.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String zip;
    private String phone;
    private String email;
    private Date udate;
    private int state;

    public User(String username, String password, String zip, String phone, String email, Date udate, int state) {
        this.username = username;
        this.password = password;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.udate = udate;
        this.state = state;
    }

    public User(String username, String password) {
        this.username=username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", udate=" + udate +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User() {
    }

    public User(int id, String username, String password, String zip, String phone, String email, Date udate, int state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.udate = udate;
        this.state = state;
    }
}
