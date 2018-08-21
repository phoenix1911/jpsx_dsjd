package lilstener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *会话监听器
 */
public class Test2_SessionLister implements HttpSessionListener, HttpSessionAttributeListener {
    public Test2_SessionLister() {
        System.out.println("session监听器创建");
    }
    public void attributeRemoved(HttpSessionBindingEvent se)  {
        System.out.println("session范围移除值："+se.getName()+"--"+se.getValue());
    }
    public void attributeAdded(HttpSessionBindingEvent se)  {
        System.out.println("session范围添加值："+se.getName()+"--"+se.getValue());
    }
    public void attributeReplaced(HttpSessionBindingEvent se)  {
        System.out.println("session范围替换值："+se.getName()+"--"+se.getValue()+
                ",新值:"+se.getSession().getAttribute(se.getName()));
    }
    public void sessionCreated(HttpSessionEvent se)  {
        System.out.println("session对象创建");
    }
    public void sessionDestroyed(HttpSessionEvent se)  {
        System.out.println("session对象销毁");
    }

}
