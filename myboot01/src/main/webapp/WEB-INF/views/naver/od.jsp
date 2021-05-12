<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String image = request.getParameter("image");
	String result = (String)request.getAttribute("odResult");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#result").text('<%=result%>')
	var json = JSON.parse('<%=result %>');
	$("#count").text("탐지객체수 = " + json.predictions[0].num_detections + "개")
	$("#names").text("객체이름 : " + json.predictions[0].detection_names)
	$("#confidence").text("확률 = ")
	for(var i = 0; i < json.predictions[0].detection_scores.length; i++){
		$("#confidence").append
		(parseInt(parseFloat(json.predictions[0].detection_scores[i]) *100) + "% ")
			
	}
	
	//캔버스에 이미지 로드(canvas 태그 + canvas 자바스크립트 라이브러리)
	var imagecanvas = document.getElementById("imagecanvas")//htmlobject타입
	var context = imagecanvas.getContext("2d")
	context.fillStyle = "red"
	context.font = '15px batang'
	context.strokeStyle = 'green'
	context.lineWidth = 3
	
	//이미지 로드
	var image = new Image()
	image.src = "/faceimages/<%=image%>"
	image.onload = function(){
		context.drawImage(image, 10, 10, image.width, image.height)
		var names = json.predictions[0].detection_names
		var confidence = json.predictions[0].detection_scores
		var boxes = json.predictions[0].detection_boxes
		
		for(var i = 0; i < names.length; i++){
			//if(confidence[i]>=0.9){
				var y1 = boxes[i][0]*image.height
				var x1 = boxes[i][1]*image.width
				var y2 = boxes[i][2]*image.height
				var x2 = boxes[i][3]*image.width
				
				//이름 : 00% 출력
				context.fillText(names[i]+" : " + parseInt(confidence[i]*100) + "%", x1+10, y1+10)
				
				//사각형 그려서 출력
				context.strokeRect(x1+10, y1+10, x2-x1, y2-y1)
			//}//if end
		}//for end
	}//image onload end
	//var imagecanvas = $("#imagecanvas")//jquery객체타입
	//var context = imagecanvas.getContext("2d")

})
</script>
<%-- <script>
window.onload = function(){
	var result = document.getElementById("result");
	var count = document.getElementById("count");
	var names = document.getElementById("names");
	var confidence = document.getElementById("confidence");
	
	<%
	String image = request.getParameter("image");
	String result = (String)request.getAttribute("odResult");
	/* JSONObject obj = new JSONObject(result);
	JSONArray predictions = (JSONArray)obj.get("predictions");
	JSONObject pd = (JSONObject)predictions.get(0);
	//서비스나 컨트롤러 구현한다면 - org.json.JSONObject, org.json.JSONArray, 
	//jsp 구현한다면 - 1 자바 json 파싱 -  org.json.JSONObject, org.json.JSONArray
	
	int nd = (int)((JSONObject)pd).get("num_detections");	 */
	%>
	var json = JSON.parse('<%=result %>');
	count.innerHTML += "탐지객체수 = " + json.predictions[0].num_detections + " "
	names.innerHTML += "객체이름 : " + json.predictions[0].detection_names
	confidence.innerHTML += "확률 : "
	for(var i = 0; i < json.predictions[0].detection_scores.length; i++){
		confidence.innerHTML += 
			parseInt(parseFloat(json.predictions[0].detection_scores[i]) *100) + "% "
	}
	
	result.innerHTML += <%=nd%>
	<%

	JSONArray detection_names = (JSONArray)((JSONObject)pd).get("detection_names");	
	for(Object dn : detection_names){
		String name = (String)dn;
		%>
		names.innerHTML += "<%=name%>, "
		<%
	}
	
	JSONArray detection_scores = (JSONArray)((JSONObject)pd).get("detection_scores");
	for(Object ds : detection_scores){
		BigDecimal confidence = (BigDecimal)ds;
		%>
		confidence.innerHTML += "<%=Math.round(confidence.doubleValue() * 100) %>% "
		<%
	}
	
	%>
	
} //window onload end
</script> --%>
</head>
<body>
<div id="result"></div>
<div id="count"></div>
<div id="names"></div>
<div id="confidence"></div>
<canvas id="imagecanvas" width=500 height=500 style="border: 2px solid pink"></canvas>
</body>
</html>