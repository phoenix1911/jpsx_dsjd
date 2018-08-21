package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 10:05.
 */
public class Test5_LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("**Test5");
        //如果当前请求对应的客户端已有用户登陆,放行,反之,跳转到登陆页面去
        //登陆成功,就会以key值为usr,将当前登陆用户存到session范围中
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取session 如果已有,获取已有的;如果没有为null
        HttpSession session = req.getSession();
        if (session == null) {
            System.out.println("当前无session,跳转到登陆页面");
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            System.out.println("当前有session,已有会话,继续判断是否有user");
            if (session.getAttribute("user") != null) {
                System.out.println("当前已有用户登陆,放行");
                chain.doFilter(req, resp);
            } else {
                System.out.println("有session无用户,跳转到登陆页面");
                resp.sendRedirect(req.getContextPath() + "/login.html");
            }
        }


        chain.doFilter(request, response);
    }
}
