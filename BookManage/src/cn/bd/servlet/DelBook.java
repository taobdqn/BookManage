package cn.bd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.impdao.BookManageDao;

public class DelBook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DelBook() {
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//out.print("<script type='text/javascript'>"+"confirm('确认删除?')"+"</script>");
		int id=Integer.parseInt(request.getParameter("id"));
		int result=new BookManageDao().deleteBook(id);
		
		String contextPath=request.getContextPath();
		if(result>0){
			out.print("<script type='text/javascript'>" +
					"alert('删除成功!');" +"location.href='"+contextPath+"/index.jsp';</script>");
			//out.print("<script type='text/javascript'>"+
			//"alert('删除成功!');"+"location.href='"+contextPath+"/index.jsp';</script>");
		}else{
			out.print("<script type='text/javascript'>"+"alert('删除失败!');"+"location.href='"+contextPath+"/index.jsp';</script>");
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
