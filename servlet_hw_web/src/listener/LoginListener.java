package listener;

import bean.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by Tjl on 2018/8/23 16:27.
 */
public class LoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //session.setAttribute("user",user);
        String name = se.getName();
        ServletContext servletContext = se.getSession().getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        if ("user".equals(name)) {
            User user = (User) se.getSession().getAttribute("user");
            if (count == null) {
                count = 0;
            }
            count++;
            servletContext.setAttribute("count",count);
            System.out.println(user.getUsername()+"用户登陆,当前在线人数有"+count+"人");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se.getName();
        if ("user".equals(name)) {
            ServletContext servletContext = se.getSession().getServletContext();
            Integer count = (Integer) servletContext.getAttribute("count");
            count--;
            //更新
            servletContext.setAttribute("count",count);
        }



    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
