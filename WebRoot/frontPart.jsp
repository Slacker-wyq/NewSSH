<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<h3><a href="frontPage.action">首页</a></h3>
<s:iterator value="newses" var="news">
<div class="panel panel-primary" style="width: 400px;float: left;margin-left: 50px;margin-top: 50px">
    <div class="panel-heading" style="height: 50px">
        <h3 class="panel-title"><a href="frontLook.action?cid=<s:property value="#news.id"/>"><s:property value="#news.title"/></a></h3>
    </div>
    <div class="panel-body" style="overflow:hidden;text-overflow:ellipsis;height: 100px">
        <s:property value="#news.content"/>
    </div>
</div>

</s:iterator>


</body>
</html>