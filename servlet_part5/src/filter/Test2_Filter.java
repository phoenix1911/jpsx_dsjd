package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 9:33.
 */
public class Test2_Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter2创建");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter2开始处理请求");
        chain.doFilter(request, response);
        System.out.println("filter2处理请求结束");
    }

    @Override
    public void destroy() {
        System.out.println("Filter2销毁");
    }
}
