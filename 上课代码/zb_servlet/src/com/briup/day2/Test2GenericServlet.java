package com.briup.day2;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * day2 test2:创建Servlet的第二种方式，继承自javax.servlet.GenericServlet
 * 			  GenericServlet实现了Servlet接口，实现了其中4个方法，未实现:servcie
 * 			  自定义servlet需要实现一个方法servcie，也可以[重写]其他4个方法。
 * 			 
 * */
public class Test2GenericServlet extends GenericServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("此时还未赋值："+getServletConfig());
		System.out.println("1.赋值成员变量,2.调用无参重载的init，这个有参的init不要重写");
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("GenericServlet的自定义的无参init没有任何操作，重写："+getServletConfig());
	}
	@Override
	public String getServletInfo() {
		System.out.println("GenericServlet的getServletInfo返回空字符串，我要重写");
		return "zhongbei_2018-8-17";
	}
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("GenericServlet实现的getServletConfig方法");
		return super.getServletConfig();
	}
	@Override
	public void destroy() {
		System.out.println("GenericServlet实现的destroy没有任何操作，要重写");
	}
	//返回一张图片
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println(getServletInfo());
		//1.找到图片，创建图片的字节输入流
		//相对当前运行时类的路径
		InputStream is = this.getClass().getResourceAsStream("../../../sn.jpg");
		
		//生成响应头ContentType: image/jpeg，通知浏览器，发送的文件是图片
		res.setContentType("image/jpeg");
		//2.获取响应字节输出流
		ServletOutputStream os = res.getOutputStream();
		//3.输出(边读边写，读多少写多少)
		//字节数字bs：承载每次读到的字节信息
		byte[] bs = new byte[100];
		//数字len:记录每次读取了多少字节
		int len = -1;
		while((len=is.read(bs))!=-1){
			os.write(bs, 0, len);
		}
		os.flush();
		is.close();
		os.close();
	}

}
