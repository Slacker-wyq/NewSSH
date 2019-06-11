<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
    #top{
    	width:1000px;
    	 height:80px;
    	 border: 1px solid black;
    }
    
    a{
    text-decoration: none;
    
    }
    </style>
	

  </head>
  
  <body style="background-color: #ADD8E6">
  <div id="top" style="background-color: #ADD8E6;border: 0;padding-top: 50px" >
  	<s:form action="listNewsPart.action" align="center" >
  	<s:select name="cid" list="categorys" listKey="id" listValue="categoryName" headerKey="-1" headerValue="---请选择新闻类型---" ></s:select>
  	<s:submit value="查看新闻"/>
  	</s:form>
  </div>
  <br><br><br><div class="container" >
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr class="warning">
                    <th>
                        序号
                    </th>
                    <th>
                        标题
                    </th>
                    <th>
                        发布时间
                    </th>
                    <th>
                        类型
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
   		<s:iterator value="newses" var="news" status="stu">
   			<tr class="info">
   				<td ><s:property value="#stu.count"/> </td>
   				<td ><s:a href="newsLook.action?cid=%{#news.id}"><s:property value="#news.title" /></s:a> </td>
   				<td ><s:property value="#news.issueTime" /></td>
   				<td ><s:property value="#news.category.categoryName"/></td>
   				<td>
   					<s:a href="newsUpdate.action?cid=%{#news.id}">修改</s:a>
   					<s:a href="newsDelete.action?cid=%{#news.id}">删除</s:a>
   				</td>
   			</tr>
   		</s:iterator>
   		</tbody>
   </table>
   </div>
   </div>
   </div>
   <div align="center">
   <s:if test="#session.pageNum!=1">
		<a href="listNewsPart.action?pageNum=1&cid=${session.cid}">首页</a>
  	</s:if>
  	<s:if test="#session.pageNum!=1">
  	<a href="listNewsPart.action?pageNum=${session.pageNum-1}&cid=${session.cid}">上一页</a>
  	</s:if>
  	<c:forEach var="i" begin="1" end="${session.pageTotal}">
  		<a href="listNewsPart.action?pageNum=<c:out value="${i}"/>&cid=${session.cid}">${i }</a>
  	</c:forEach>
  	<s:if test="#session.pageNum!=#session.pageTotal">
  	<a href="listNewsPart.action?pageNum=${session.pageNum+1}&cid=${session.cid}">下一页</a>
  	</s:if>
  	<s:if test="#session.pageNum!=#session.pageTotal">
		<a href="listNewsPart.action?pageNum=<s:property value="#session.pageTotal"/>&cid=${session.cid}">尾页</a>
  	</s:if>
  	
</div>
  </body>
</html>
