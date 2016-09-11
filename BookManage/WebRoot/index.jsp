<%@page import="cn.bd.impdao.BookManageDao"%>
<%@page import="cn.bd.entity.BookManage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/checkDel.js"></script>
  </head>
  <%
  	request.setCharacterEncoding("utf-8");

  	List<BookManage> list=new ArrayList<BookManage>();
  	list=new BookManageDao().searchAll();
  	request.setAttribute("list", list);
   %>
  <body>
    <form>
    	<table align="center" border="1px">
    		<tr id="one">
    			<td colspan="5">个人图书管理</td>
    		</tr>
    		<tr id="two">
    			<td colspan="5">图书信息</td>
    		</tr>
    		<tr>
    			<td>图书名称</td>
    			<td>图书作者</td>
    			<td>购买时间</td>
    			<td>图书分类</td>
    			<td >操作</td>
    		</tr>
    		
    		
    		<c:forEach var="entry" items="${requestScope.list}" varStatus="status">
    		
    		<!-- 隔行变色 -->
    		<tr <c:if test="${status.index %2==0 }"> style="background-color:rgb(219,241,212);"</c:if>>
    		
    			<td style="display:none" id="id">${entry.getB_id() }</td>  
    			
    			
   				<td>${entry.getB_name()}</td>
   				<td>${entry.getB_author()}</td>
   				<td>${entry.getB_time()}</td>
   				<td>
					<c:choose>
						<c:when test="${entry.getB_bype()==0}">
							计算机/软件
						</c:when>
						<c:when test="${entry.getB_bype()==1}">
							文学/摘要
						</c:when>
						<c:when test="${entry.getB_bype()==2}">
							杂项
						</c:when>
					</c:choose>
   				</td>
   				
   				<td style="cursor:pointer;" onclick="return chDel()">删除</td>
    		</tr>
    		</c:forEach>
    		
    		<tr id="botton">
    			<td colspan="5"><a href="addBook.jsp">新增图书信息</a></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
