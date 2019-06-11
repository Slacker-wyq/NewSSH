<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
   <h3>发布新闻:</h3>
   <s:form action="newsAdded.action" border="1" method="post" enctype="multipart/form-data">
       
   		<table border="1" cellspacing="0" cellpadding="6">
   		<tr>
   			<td width="100px">标题</td>
   			<td width="1000px"><s:textfield name="news.title"/> 
   				<s:fielderror><s:param>news.title</s:param></s:fielderror>
   			</td>
   		</tr>
   		<tr>
   			<td>类型</td>
   			<td><s:select name="cid" list="categorys" listKey="id" listValue="categoryName" headerKey="-1" headerValue="---请选择类型---"></s:select> 
   			<s:fielderror><s:param>cid</s:param></s:fielderror>
   			</td>
   			
   		</tr>
   		<tr>
   			<td>内容</td>
   			<td><s:textarea rows="8" cols="90" name="news.content"></s:textarea>
				<s:fielderror><s:param>news.content</s:param></s:fielderror>   			
   			</td>
   		</tr>
   		<tr>
   			<td>配图</td>
   			<td><s:file name="file" /></td>
   		</tr>
   		<tr>
   			<td>来源</td>
   			<td><s:textfield name="news.froms"/> 
   			<s:fielderror><s:param>news.froms</s:param></s:fielderror>
   			</td>
   		</tr>
   		<tr>
   			<td colspan="2"><s:submit value="添加"/></td>
   		</tr>
   		</table>
   		
   </s:form>
  </body>
  
</html>
