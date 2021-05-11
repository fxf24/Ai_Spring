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
<%
String[] filelist = (String[])request.getAttribute("filelist");
for(String file : filelist){
	if(file.contains("font")){
%>
<img src="/faceimages/<%=file%>" width=100 height=100><br>
<a href="/ocr?image=<%=file %>"> <%=file %></a><br>
<% 
	}
}

%>

</body>
</html>