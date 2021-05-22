<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>파일 업로드 폼</h1>
<form action="<%=request.getContextPath()%>/projecttest"
 method=post enctype="multipart/form-data">
파일1 <input type = file name="file"><br>
<input type=submit value="파일전송">
</form>

</body>
</html>