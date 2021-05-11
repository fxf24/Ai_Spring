<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="ch.qos.logback.core.pattern.LiteralConverter"%>
<%@page import="java.util.Dictionary"%>
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
<%
String[] filelist = (String[])request.getAttribute("filelist");
for(String file : filelist){
%>
<img src="/faceimages/<%=file%>" width=100 height=100><br>
<a href="/face2?image=<%=file %>"> <%=file %></a><br>
<% 
}

%>

</body>
</html>