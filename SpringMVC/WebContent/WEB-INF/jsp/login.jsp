<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
		<form:form action="login" method="post" modelAttribute="login">
			帳號:<form:input path="account" /><form:errors path="account" /><br />
			密碼:<form:input path="password" /><form:errors path="password" /><br />
			<input type="submit" value="登入" /><br />
		</form:form>
	</div>
</body>
</html>