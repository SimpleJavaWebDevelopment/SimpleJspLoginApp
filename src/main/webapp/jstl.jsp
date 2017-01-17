<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login success</title>
</head>
<body>

Hello from jstl

<br>
<!-- this will initialize user attribute from request scope -->

<jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request"> 
</jsp:useBean>

Hello user in request <%=user.getUserName() %>

<br>
Hello user in request from jstl <jsp:getProperty property="userName" name="user"/>

<!-- jsp try to find sender in request scope and it will not find it
 then it will create new property sender  -->
<jsp:useBean id="sender" class="org.koushik.javabrains.dto.User" scope="request"> 
	<jsp:setProperty property="userName" name="sender" value="New Sender Name"/>
</jsp:useBean>

<br>
Hello sender in request from jstl <jsp:getProperty property="userName" name="sender"/>

<!-- request.getAttribute -- 
		:: used to define attribute in particular scope( request/session/applicationContext)
		:: Set and get by Server program -->
<!-- request.getParamenter ::
	:: get the parameter being passed to HttpRequest
	:: Set by Client in the form 
	:: get by server  program   -->
</body>
</html>