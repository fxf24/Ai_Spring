<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String image = request.getParameter("image");
	String result = (String)request.getAttribute("poseResult");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var json = JSON.parse('<%=request.getAttribute("speechResult") %>')
var text = json.text
$(document).ready(function(){
	$("#result").text(text)
/* 	var result = document.getElementById("result")
	result.innerHTML = text */
})
</script>
</head>
<body>
<script>

</script>

<textarea id="result" rows=5 cols=100>
</textarea>
<audio src="/faceimages/<%=image %>" controls="controls"></audio>
</body>
</html>