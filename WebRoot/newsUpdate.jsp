<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
   <h3>更新新闻类型</h3>
   <s:form action="newsUpdated">
   		<s:hidden name="news.id" value="%{news.id}"/>
   		<s:hidden name="news.issueTime" value="%{news.issueTime}"/>
   		<table border="1" cellspacing="0" cellpadding="6">
   		
   		<tr>
   			<td width="100px">标题</td>
   			<td width="1000px"><s:textfield name="news.title"/></td>
   			
   		</tr>
   		<tr>
   			<td>类型</td>
   			<td><s:select name="cid" list="categorys"  value="%{news.category.id}" listKey="id" listValue="categoryName" headerKey="-1" headerValue="---请选择类型---"></s:select> </td>
   			
   		</tr>
   		<tr>
   			<td>新闻内容</td>
   			<td><textarea rows="8" cols="90" name="news.content"><s:property value="news.content"/> </textarea></td>
   		</tr>
   		<tr>
   			<td>来源</td>
   			<td><s:textfield name="news.froms"/> </td>
   		</tr>
   		<tr>
   			<td colspan="2"><s:submit value="更新"/></td>
   		</tr>
   		</table>
   	
   </s:form>
  </body>
</html>
