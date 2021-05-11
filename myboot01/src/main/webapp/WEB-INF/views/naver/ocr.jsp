<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
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
	var div = document.getElementById("ocrResult");
	
	<%
	String image = request.getParameter("image");
	String ocrResult = (String)request.getAttribute("ocrResult");

	JSONObject obj = new JSONObject(ocrResult);
	JSONArray imgs = (JSONArray)obj.get("images");
	//out.println(imgs);

	JSONArray fields = (JSONArray)imgs.getJSONObject(0).get("fields");

	for(Object f:fields){
		boolean linebreak = (boolean)((JSONObject)f).get("lineBreak");
		String inferText = (String)((JSONObject)f).get("inferText");
		
	%>
		div.innerHTML += "<%=inferText%>";
	<%
		if(linebreak){
	%>
			div.innerHTML += "<br>";
	<%
		}
	}

	%>
});
</script>
</head>
<body>
<script>
window.onload = function(){
	
}
</script>

<img src="/faceimages/<%=image%>"><br>
<div id="ocrResult">
</div>
</body>
</html>