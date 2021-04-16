<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>보드리스트</h1>
<table border="3">
	<c:forEach items="${list }" var="bdto">
		<tr><td> ${bdto.seq } </td> 
		<td><a href="<%=request.getContextPath() %>/boarddetail?seq=${bdto.seq }"> ${bdto.title }</a> </td>
		<td> ${bdto.writer } </td><td> ${bdto.viewcount } </td></tr>
	</c:forEach>
</table>

</body>
</html>