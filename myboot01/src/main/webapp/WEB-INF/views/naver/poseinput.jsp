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
	//"." 특수문자 분리
	String file_split[] = file.split("[.]");//문자열 패턴(자바 - a.b) .:아무문자 하나가 와도 된다
	String ext = file_split[file_split.length-1];
	if(!(ext.equals("mp3") || ext.equals("txt"))){
%>
<img src="/faceimages/<%=file%>" width=100 height=100><br>
<a href="/pose?image=<%=file %>"> <%=file %></a><br>
<% 
	}
}

%>

</body>
</html>