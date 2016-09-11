<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/addBook.css">
	<script type="text/javascript" src="jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/check.js"></script>
  </head>
  
  <body>
    <div id="div">
    	
    	<form method="post" action="addBook" >
    		<table align="center" border="1px">
    			<tr>
    				<td colspan="2" align="left">添加图书信息</td>
    			</tr>
    			<tr>
    				<td colspan="2"><h3>新增图书信息</h3></td>
    			</tr>
    			<tr>
    				<td>图书名称:</td>
    				<td><input type="text" name="bookName" id="bookname" style="width: 100%; height: 100%"></td>
    			</tr>
    			<tr>
    				<td>图书作者:</td>
    				<td><input type="text" name="bookAuthor" id="bookauthor" style="width: 100%; height: 100%"></td>
    			</tr>
    			<tr>
    				<td>购买日期:</td>
    				<td><input type="text" name="bookTime" id="buytime" style="width: 100%; height: 100%"></td>
    			</tr>
    			<tr>
    				<td>图书类别:</td>
    				<td>
    					<select name="bookType" style="width: 100%; height: 100%">
    						<option value="3">选择所属分类</option>
    						<option value="0">计算机/软件</option>
    						<option value="1">小说/文摘</option>
    						<option value="2">杂项</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2"><input type="submit" value="添加图书" onclick="return checkAll()"></td>
    			</tr>
    		</table>
    	</form>
    </div>
  </body>
</html>
