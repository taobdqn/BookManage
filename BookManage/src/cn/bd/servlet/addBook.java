package cn.bd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.entity.BookManage;
import cn.bd.impdao.BookManageDao;;
public class addBook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addBook() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String bookName=request.getParameter("bookName");
		String bookAuthor=request.getParameter("bookAuthor");
		String bookTime=request.getParameter("bookTime");
		String bookType=request.getParameter("bookType");
//		System.out.println("bookType是:"+bookType);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date Time = null;
		try {
			Time =dateFormat.parse(bookTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将java.util.Date 的时间类型转换为SQL 的时间类型
		java.sql.Date date=new java.sql.Date(Time.getTime());
		
		
		BookManage b=new BookManage();
		b.setB_name(bookName);
		b.setB_author(bookAuthor);
		b.setB_time(date);
		b.setB_bype(Integer.parseInt(bookType));
		
		BookManageDao id=new BookManageDao();
		int result=id.addBook(b);
		
		//System.out.println("图书是:"+bookType);
		String contextPath=request.getContextPath();
		if(result>0){
			out.print("<script type='text/javascript'>"+ "alert('添加图书成功!');"+ "location.href='"+contextPath+"/index.jsp';</script>");
		}
		else {
			out.print("<script type='text/javascript'>"+ "alert('添加图书失败!');"+ "location.href='"+contextPath+"/addBook.jsp';</script>");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
