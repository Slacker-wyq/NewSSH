<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
    <script type="text/javascript">
	function wyq(){
		if(<s:property value="#session.find"/>=!""){
			this.alert("${session.find}");
			
		}
		}
	</script>
</head>
<body onload="wyq()">
<div class="jumbotron text-center" style="margin-bottom:0;background-color: cornflowerblue">
    <img src="images/center1.jpg" width="233" height="133">
    <p>引领新时代</p>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">国民网</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">主页</a></li>
                <li><a href="login.jsp">登录</a></li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                       类型
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                    <s:iterator value="categorys" var="category" status="stu">
   					  <li><a href="frontPart.action?cid=<s:property value="#category.id" />"><s:property value="#category.categoryName" /></a></li>
   					</s:iterator>
                    </ul>
                </li>

            </ul>
            <div style="float: right">
				  <form class="navbar-form navbar-left" action="frontTime.action" method="post">
                    <div class="form-group">
                       <input type="date" class="form-control" name="startDate"> <span style="color:white">至</span> <input type="date" class="form-control" name="endDate">
                    </div>
                    <input type="submit" class="btn btn-default" value="搜索">
		
                </form>            
                <form class="navbar-form navbar-left" action="frontFind.action" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索" name="title">
                    </div>
                    <input type="submit" class="btn btn-default" value="搜索">
					
                </form>
            </div>
        </div>

    </div>

</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h2>${session.clicks.get(0).getCategory().getCategoryName()}</h2>
            <h5><a href="frontLook.action?cid=${session.clicks.get(0).getId()}">${session.clicks.get(0).getTitle()}</a></h5>
            <div class="fakeimg" style="background-image: url('${session.clicks.get(0).getImgs()}');"></div>
            <p>${session.clicks.get(0).getContent()}</p>
            <h3>更多热搜</h3>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="frontLook.action?cid=${session.clicks.get(4).getId()}">${session.clicks.get(4).getTitle()}</a></li>
                <li><a href="frontLook.action?cid=${session.clicks.get(5).getId()}">${session.clicks.get(5).getTitle()}</a></li>
                <li><a href="frontLook.action?cid=${session.clicks.get(6).getId()}">${session.clicks.get(6).getTitle()}</a></li>
            </ul>
            <hr class="hidden-sm hidden-md hidden-lg">
        </div>
        <div class="col-sm-8">
            <h2>${session.clicks.get(1).getCategory().getCategoryName()}</h2>
           <h5><a href="frontLook.action?cid=${session.clicks.get(1).getId()}">${session.clicks.get(1).getTitle()}</a></h5>
            <div class="fakeimg" style="background-image: url('${session.clicks.get(1).getImgs()}');"></div>
            <p>${session.clicks.get(1).getContent()}</p>
          
            <br>
           <h2>${session.clicks.get(2).getCategory().getCategoryName()}</h2>
            <h5><a href="frontLook.action?cid=${session.clicks.get(2).getId()}">${session.clicks.get(2).getTitle()}</a></h5>
            <div class="fakeimg" style="background-image: url('${session.clicks.get(2).getImgs()}');"></div>
            <p>${session.clicks.get(2).getContent()}</p>
        </div>
    </div>
</div>
 <% 
   	session.invalidate();
  %>

</body>
</html>