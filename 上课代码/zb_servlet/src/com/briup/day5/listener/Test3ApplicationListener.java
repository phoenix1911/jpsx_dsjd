package com.briup.day5.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *application相关的监听器
 */
public class Test3ApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    public Test3ApplicationListener() {
    	System.out.println("application监听器创建");
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("application对象创建"+sce.getServletContext().getContextPath());
    }
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("application范围内添加值："+scae.getName()+"--"+scae.getValue());
    }
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("application范围内替换值："+scae.getName()+"--"+scae.getValue()+
    			"新值："+scae.getServletContext().getAttribute(scae.getName()));
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("application范围内移除值："+scae.getName()+"--"+scae.getValue());
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("application对象销毁");
    }
	
}
