<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<c:import url="/titles/resource"></c:import>
  
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>index</title>
</head>

<body>
<!-- header -->
<c:import url="/titles/header"></c:import>

  <h3>這裡是首頁</h3>
    <img alt="This is Jake" src="<%= request.getContextPath() %>/images/jake.jpg" />
</body>
</html>