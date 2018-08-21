package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 9:58.
 * 编码过滤器
 */
public class Test4_encondingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("**Test4");
        System.out.println(encoding);
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
