<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <!-- //for-mobile-apps -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript">
	function wyq(){
		var s=document.getElementById("msg").value;
		if(s!=""){
		alert(s);
		}
	}
</script>

</head>
<body onload="wyq()">
    <div class="main">
        <h1>
            国民网后台登录系统
        </h1>
        <form action="login.action">
            <input type="text" required="" name="username">
            <input type="password" required="" name="password">
            <input type="submit" value="登录">
        </form>
    </div>
  <input type="hidden" id="msg" value="<s:property value="str"/>"/>
   
</body>
</html>