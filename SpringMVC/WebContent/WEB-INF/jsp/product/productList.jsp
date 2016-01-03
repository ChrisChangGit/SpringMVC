<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<c:import url="/titles/resource"></c:import>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/jqGrid/ui.jqgrid.css" />
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jqGrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jqGrid/i18n/grid.locale-tw.js"></script>

<script type="text/javascript">
  var gridUrl = '<%= request.getContextPath() %>/product/all';
  $(document).ready(function() {
    $("#gridTable").jqGrid({
      url : gridUrl,
      datatype : 'json',
      height: 250,
      width:700,
      colNames : ['ID', 'NAME'],
      colModel : [
        {name : 'id', index : 'PRODUCT_ID'},
	   	{name : 'name', index :'PRODUCT_NAME'},
	  ],
      jsonReader:{
        repeatitems : false,
      },
      viewrecords: true,
      rowNum:10,
      sortname: 'PRODUCT_ID',
      pager: '#pager',
      caption: "Product"
    });
  });
</script>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product</title>
</head>

<body>
<!-- header -->
<c:import url="/titles/header"></c:import>

  <table id="gridTable"></table>
  <div id="pager"></div>
</body>
</html>