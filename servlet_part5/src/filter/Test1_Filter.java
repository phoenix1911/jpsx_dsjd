package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 9:12.
 */
public class Test1_Filter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1 初始化 "+filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter1 开始处理reques");
        String name = request.getParameter("name");
        HttpServletRequest req = (HttpServletRequest)request;

        System.out.println("filter 1中 获取的请求信息:"+name+","+req.getServletPath());
        System.out.println("filter1只是简单做个记录,放行");

        if (name != null) {
            chain.doFilter(request, response);
        } else {
            //重定向,小心死循环
            req.getRequestDispatcher("/html/test1.html").forward(request, response);

        }

        chain.doFilter(request, response);
        System.out.println("filter处理结束");

    }

    @Override
    public void destroy() {
        System.out.println("过滤器1 销毁");
    }
}
