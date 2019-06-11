<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<style>
		.menu{
			margin-top:50px;
			width:300px;
			height:900px;
			float:left;
			text-align: center;
		}
		
		.item{
			width:300px;
			font-size:30px;
			text-align: center;
		}
		
		.menu a{
			text-decoration: none;
		}
	</style>
  </head>
  <%
if(session.getAttribute("login")==null){
response.sendRedirect("login.jsp"); //userName为空,则跳转到登陆界面

}%>
  <body style="background-color: #ADD8E6">
    <div class="menu">
    <div class="item">类型管理</div>
    <p><a href="categoryList.action" target="iframe1">类型查看</a></p>
     <p><a href="addCategory.jsp" target="iframe1">类型发布</a></p>
    <div class="item">类型管理</div>
    <p><a href="newsList.action" target="iframe1">新闻查看</a></p>
     <p><a href="newsAdd.action" target="iframe1">新闻发布</a></p>
    </div>

<iframe name="iframe1" style="float: left;width:1000px;height:800px;">


</iframe>
  </body>
</html>
