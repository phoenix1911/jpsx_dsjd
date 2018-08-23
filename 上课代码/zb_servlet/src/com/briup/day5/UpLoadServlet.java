package com.briup.day5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传&普通参数获取
 * */
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	
	@Override
	public void init() throws ServletException {
		//在web.xml中把path值传过来
		path = getServletConfig().getInitParameter("path");
	}
	
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//获得上传目录的绝对路径
		// I:\\briup\\zhongbei\\apache-tomcat-7.0.72\\webapps\\zb_servlet\\upload
		String realpath = this.getServletContext().getRealPath(path);
		System.out.println(request.getParameter("name")+"文件要上传的位置："+realpath);
		//内存中--path            new File(realpath,fileName);
		
		try {
			//构造一个文件上传处理对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upLoad = new ServletFileUpload(factory);
			
			//获得表单中提交内容,fileItem:可能是文件控件，也可能是普通表单控件
			List<FileItem> list = upLoad.parseRequest(request);

			for (FileItem fileItem : list) {
				//fileItem.isFormField()返回true表示是普通的表单组件
				//fileItem.isFormField()返回false表示是上传
				if (fileItem.isFormField()) {
					// getName()方法返回的是文件名字 普通表单组件有文件 返回NULL
					//普通表单控件传入的key与value
					String FieldName = fileItem.getFieldName();
					String Content = fileItem.getString("UTF-8");
					
					System.out.println("普通控件："+FieldName+": "+Content);
					//为了后面可以把普通参数从request中拿出来
					request.setAttribute(FieldName, Content);
				} else {
					//取得上传文件的名字
					String fileName = fileItem.getName();
					//避免文件名字重复
					fileName = System.currentTimeMillis()+fileName;
					File file = new File(realpath, fileName);
					//把上传文件进行指定目录
					fileItem.write(file);
				}
			}
			System.out.println("处理结束后"+request.getAttribute("name"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
