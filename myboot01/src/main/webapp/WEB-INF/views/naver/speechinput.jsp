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
<h1>stt 서비스를 위한 파일 선택</h1>
<%
String [] langs = {"Kor", "Eng", "Jpn", "Chn"};
String [] langnames = {"한국어", "영어", "일본어", "중국어"};
%>
<form action="/speech">
	언어 선택 :
	<%for(int i = 0; i < langs.length; i++){%>
		<input type=radio name="lang" value="<%=langs[i]%>"> <%=langnames[i] %>
	<%
	}
	%>
	<br>
	파일 선택 :
	<select name="image">
	<%
	String[] filelist = (String[])request.getAttribute("filelist");
	for(String file : filelist){
		//"." 특수문자 분리
		String file_split[] = file.split("[.]");//문자열 패턴(자바 - a.b) .:아무문자 하나가 와도 된다
		String ext = file_split[file_split.length-1];
		if(ext.equals("mp3")){
	%>
			<option value="<%=file %>"><%=file %></option>
	<% 
		}//if end
	}//for end
	
	%>
	</select>
	
	<input type="submit" value="텍스트로 변환 요청">
</form>

</body>
</html>