<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<c:import url="/titles/resource"></c:import>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product</title>
</head>

<body>
<!-- header -->
<c:import url="/titles/header"></c:import>

  <table class="table table-hover table-bordered">
    <caption>Product</caption>
    <thead>
      <tr>
        <th>id</th>
        <th>name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="row" items="${rows}">
        <tr>
          <td>${row.id}</td>
    	  <td>${row.name}</td>
    	</tr>
      </c:forEach>
    </tbody>
  </table>
  <ul class="pager">
    <li><a href="<%= request.getContextPath() %>/product/productListTable?page=1">第一頁</a></li>
    <li>
      <c:choose>
        <c:when test="${page > 1}">
      	  <a href="<%= request.getContextPath() %>/product/productListTable?page=${page - 1}">上一頁</a>
        </c:when>
        <c:otherwise>
          <a href="#">上一頁</a>
        </c:otherwise>
      </c:choose>
    </li>
    <li><a href="#">${page}</a></li>
    <li>
      <c:choose>
        <c:when test="${page < total}">
          <a href="<%= request.getContextPath() %>/product/productListTable?page=${page + 1}">下一頁</a>
        </c:when>
        <c:otherwise>
          <a href="#">下一頁</a>
        </c:otherwise>
      </c:choose>
    </li>
    <li><a href="<%= request.getContextPath() %>/product/productListTable?page=${total}">最末頁</a></li>
  </ul>

</body>
</html>