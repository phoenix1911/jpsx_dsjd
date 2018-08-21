package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 9:52.
 * /日志过滤器,记录所有的请求信息
 */
public class Test3_logFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("**Test3");
        long start = System.currentTimeMillis();
        System.out.println("log : 本次请求的路径"+ ((HttpServletRequest)request).getServletPath());
        chain.doFilter(request,response);
        long end = System.currentTimeMillis();
        System.out.println("本次请求花费的时间: "+(end-start));
    }

    @Override
    public void destroy() {

    }
}
