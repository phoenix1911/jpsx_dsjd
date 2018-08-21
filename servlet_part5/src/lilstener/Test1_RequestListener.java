package lilstener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tjl on 2018/8/21 14:10.
 * 监听器
 */
public class Test1_RequestListener implements ServletRequestListener,ServletRequestAttributeListener {
    //监听请求对象的创建
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();

        System.out.println("请求对象创建"+servletRequest.getServletPath());
    }
    //监听请求对象的销毁
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求对象的销毁");
    }
    //监听请求范围内: 属性的替换setAttribute("key","")key:已有
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("请求访问参数替换"+srae.getName()+" : "+srae.getValue()+"  新值: "+srae.getServletRequest().getAttribute(srae.getName()));
    }
    //监听请求范围 属性的添加setAttribute("key","")

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("请求范围添加"+srae.getName()+" : "+srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("请求范围删除"+srae.getName()+" : "+srae.getValue());

    }
}
