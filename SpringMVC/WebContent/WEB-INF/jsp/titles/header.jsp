<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<ul class="nav nav-tabs" role="button">
  <li class="">
    <a href="<%= request.getContextPath() %>/index">首頁</a>
  </li>
  
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">產品</a>
    <ul class="dropdown-menu" role="menu">
	  <li><a href="<%= request.getContextPath() %>/product/productList">產品管理[jqGrid]</a></li>
	  <li><a href="<%= request.getContextPath() %>/product/productListTable">產品管理[table]</a></li>
    </ul>
  </li>
</ul>