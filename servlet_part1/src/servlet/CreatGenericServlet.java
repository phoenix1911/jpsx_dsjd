package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/17 9:04.
 * GenericServlet 实现了Servlet,实现了4个方法,有一个抽象Service
 * 有两个init方法,一个是实现了ServletCOnfig,调用重载的init 重载无参的构造方法
 */
public class CreatGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("CreatGenericServlet service...");
        //1.找到图片,创建图片的字节输入流
        //相对当前运行时时类的路径
        InputStream is = this.getClass().getResourceAsStream("../2.jpg");
        res.setContentType("image/jpeg");
        //2获取响应字节输出流
        ServletOutputStream os = res.getOutputStream();
        //3.输出(边读边写,读多少写多少)
        byte[] bs = new byte[100];
        //数字len:记录每次读取了多少字节
        int len = -1;
        while ((len = is.read(bs))!=-1) {
            os.write(bs,0,len);
        }
        os.flush();
        is.close();
        os.close();


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("此时是否赋值:"+getServletConfig());
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println(getServletConfig());
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("GenericServlet实现的destroy没有任何操作,要重写");
        super.destroy();
    }
}
