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
<h1>닮은 연예인 찾아주기</h1>
<%
String faceResult = (String)request.getAttribute("faceResult");

//faces 다음 celebrity 다음 value 다음 값 -->닮은 연예인 이름
//다음 confidence 다음 값--> 확률
/* String faceInfo[] = faceResult.split("\"faces\":");
out.println(faceInfo[1] + "<br>");
String celeInfo[] = faceInfo[1].split("\"celebrity\":");
out.println(celeInfo[celeInfo.length - 1] + "<br>");
String one = celeInfo[celeInfo.length - 1];
int valueIndex = one.indexOf("\"value\":");
int valueLength = "\"value\":".length();
int confidenceIndex = one.indexOf("\"confidence\":");
int confidenceLength = "\"confidence\":".length();
int per = 0;
String name = null;

//out.println( one.substring(valueIndex+valueLength + 1, valueIndex+valueLength + 4) + "<br>");
name = one.substring(valueIndex+valueLength + 1, valueIndex+valueLength + 4) + "<br>";
//out.println(one.substring(confidenceIndex + confidenceLength + 1, confidenceIndex + confidenceLength + 4)+ "<br>");
per = (int)(Double.parseDouble(one.substring(confidenceIndex + confidenceLength + 1, confidenceIndex + confidenceLength + 4)) * 100);
 */

JSONObject obj = new JSONObject(faceResult);
Object imsi = obj.get("faces");
JSONArray faces = (JSONArray)imsi;
boolean find = false;

for(Object cele : faces){
	JSONObject c = (JSONObject)((JSONObject)cele).get("celebrity");
	find = true;
	String value = (String)c.get("value");
	BigDecimal confidence = (BigDecimal)c.get("confidence");
	out.println("닯은 연예인=" + value + ", 닮은 확률= " + Math.round(confidence.doubleValue() * 100) + "%<br>"); 
}

String image = request.getParameter("image");
if(!find){
	out.println("닮은 연예인을 찾을 수 없습니다.");
}
%>
<img src="/faceimages/<%=image%>">
</body>
</html>