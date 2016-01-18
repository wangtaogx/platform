<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <base href="<%=basePath%>">
<title>Insert title here</title>
<script type="text/javascript" src="/platform/common/js/jquery.js" ></script>
<script type="text/javascript">
 	$(document).ready(function(){
		$('#userButton').click(function(){
			alert('login');
			$.post("/platform/platform/userinfo",{'username':'wangtao'},function(data){
				alert(data.age);
				
			});
		});
		
	}); 
</script>
</head>
<body>
<form action="/platform/platform/login" method="post">
<input type="text" name="username" value="wangtao"/>
<br/>
<input type="password" name="password" value="wangtao"/>
<br/>
<input id="loginButton" type="submit" value="登入"/>
</form>
<input id="userButton" type="button" value="用户信息"/>

</body>
</html>