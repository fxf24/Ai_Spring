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
<table border="3">
<tr><td> ${detail.title }</td></tr>
<tr><td> ${detail.contents }</td></tr>
<tr><td> ${detail.writer }</td></tr>
<tr><td> ${detail.password }</td></tr>
</table>
</body>
</html>