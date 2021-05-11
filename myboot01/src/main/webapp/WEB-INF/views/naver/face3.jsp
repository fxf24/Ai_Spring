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
<h1>얼굴 인식 서비스</h1>

<%
String faceResult = (String)request.getAttribute("faceResult");

JSONObject obj = new JSONObject(faceResult);
Object imsi = obj.get("faces");
JSONArray faces = (JSONArray)imsi;
boolean find = false;
String image = request.getParameter("image");

for(Object face : faces){
	JSONObject roi = (JSONObject)((JSONObject)face).get("roi");
	int x = (int)roi.get("x");
	int y = (int)roi.get("y");
	int width = (int)roi.get("width");
	int height = (int)roi.get("height");
	out.println("얼굴 x좌표= " + x + ", y좌표=" + y + ", width=" + width + ", height=" + height + "<br>");
	
	JSONObject emotion = (JSONObject)((JSONObject)face).get("emotion");
	String value = (String)emotion.get("value");
	BigDecimal confidence = (BigDecimal)emotion.get("confidence");
	out.println("표정=" + value + ", 표정일 확률= " + Math.round(confidence.doubleValue() * 100) + "%<br>");
	
	JSONObject gender = (JSONObject)((JSONObject)face).get("gender");
	find = true;
	value = (String)gender.get("value");
	confidence = (BigDecimal)gender.get("confidence");
	out.println("성별=" + value + ", 성별일 확률= " + Math.round(confidence.doubleValue() * 100) + "%<br>");
	
	JSONObject age = (JSONObject)((JSONObject)face).get("age");
	value = (String)age.get("value");
	confidence = (BigDecimal)age.get("confidence");
	out.println("나이=" + value + ", 나이일 확률= " + Math.round(confidence.doubleValue() * 100) + "%<br>");
%>	
<script >
	var x = <%=x %>
	var y = <%=y %>
	var width = <%=width %>
	var height = <%=height %>
	
	window.onload = function(){
		var samplecanvas = document.getElementById("samplecanvas")
		var samplecontext = samplecanvas.getContext("2d")
		
		var sampleImage = new Image()
		sampleImage.src = "/faceimages/<%=image%>"
		sampleImage.onload = function(){
			samplecontext.drawImage(sampleImage, 0, 0, sampleImage.width, sampleImage.height)
			var copyImage = samplecontext.getImageData(x, y, width, height)
		

			//색상반전 - 이미지 구성하는 기본단위 
			var faceimage = samplecontext.getImageData(x, y, width, height)
			var data = faceimage.data
			var numpixels = data.length;
			for(var i = 0; i<numpixels; i=i+4){
				data[i] = 255 - data[i]//r
				data[i+1] = 255 - data[i+1]//g
				data[i+2] = 255 - data[i+2]//b
			}
			var targetcanvas = document.getElementById("targetcanvas")
			var targetcontext = targetcanvas.getContext("2d")
			targetcontext.putImageData(faceImage, width, height)
		}
		
	}
</script>
	
<%	
}
if(!find){
	out.println("얼굴을 찾을 수 없습니다.");
}

/*	1. id = "samplecanvas"에 image 변수 저장된 파일 그리기
	2. 1번 이미지에서 얼굴 x, y, width, height 값 가져오기
	3. 1번 이미지에서 2번 영역 얼굴만 복사하여 id="targetcanvas"로 붙여넣기
*/

%>

<h1>이미지 전체 캔버스</h1>
<canvas id="samplecanvas" width=500 height=500 style="border: solid 2px pink"></canvas>
<h1>얼굴만 캔버스</h1>
<canvas id="targetcanvas" width=300 height=300 style="border: solid 2px pink"></canvas>
</body>
</html>