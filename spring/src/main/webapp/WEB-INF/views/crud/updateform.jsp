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
<form action="<%=request.getContextPath() %>/crud/update" method="post">
제목<input type=text name="title" value="${title }"><br>
내용<input type=text name="contents" value="${contents }"><br>
작성자<input type=text name="writer" value="${writer }"><br>
<input type=submit name="수정"><br>
</form>
</body>
</html>