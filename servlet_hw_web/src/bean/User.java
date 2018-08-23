package bean;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by Tjl on 2018/8/18 17:35.
 */
public class User implements HttpSessionBindingListener {
    private int id;
    private String username;
    private String password;
    private String phone;

    public User() {

    }
    public User(int id, String username, String password, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return phone != null ? phone.equals(user.phone) : user.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        ServletContext servletContext = event.getSession().getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        if (count == null) {
            count =0;
        }
        count++;
        servletContext.setAttribute("count",count);
        System.out.println(username+"用户登陆,当前在线人数有"+count+"人");

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        ServletContext servletContext = event.getSession().getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        count--;
        servletContext.setAttribute("count",count);
    }
}
