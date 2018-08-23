package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/23 15:59.
 * servlet Filter implementation class LoginFilter
 * 实现思路:
 *  1.判断用户是否
 *      登陆如果已经登陆,则不去过滤
 *      没有登陆 先要获取当前的资源名 .../success.html
 *  2.判断当前的资源名是不是login.html 或register.html
 *      如果是,则不去锅炉过滤
 *      如果不是,则跳转到登陆页面login.html
 *
 */
public class loginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强制类型转换
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        //1.判断用户是否登陆, 如果已经登陆,则不去过滤
        if (session.getAttribute("user") == null) {
            //2.先要获取当前的资源名 ../success.html
            String requestURI = req.getRequestURI();
            requestURI = requestURI.substring(requestURI.lastIndexOf("/") + 1);
            //3.判断当前的资源名是不是login.html 或register.html
            if ("login.html".equals(requestURI) || "register.html".equals(requestURI)) {
                //4.如果是,则不去过滤
                chain.doFilter(request,response);
                return;
            }
            //如果不是,则跳转到登陆页面
            resp.sendRedirect("login.html");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
