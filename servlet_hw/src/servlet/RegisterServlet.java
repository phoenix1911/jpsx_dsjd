package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/17 17:39.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("<html>");
        pw.print("	<head>");
        pw.print("		<title>注册页面</title>");
        pw.print("	<body>");
        pw.print("		<h1>注册信息</h1>");
        pw.print("		<form action='success.html' method='POST'>");
        pw.print("			姓名：<input type='text' name='name'><br>");
        pw.print("			密码：<input type='password' name='password'><br>");
        pw.print("			电话：<input type='text' name='phone'><br>");
        pw.print("			<input type='submit' value='注册'>");
        pw.print("	</body>");
        pw.print("	</head>");
        pw.print("</html>");

        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
