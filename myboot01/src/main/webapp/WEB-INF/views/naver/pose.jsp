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
$(document).ready(function(){
	var json = JSON.parse('<%=result %>')
	var resultdiv = document.getElementById("resultdiv")
	
	//캔버스에 이미지 로드(canvas 태그 + canvas 자바스크립트 라이브러리)
	var imagecanvas = document.getElementById("imagecanvas")//htmlobject타입
	var context = imagecanvas.getContext("2d")
	context.fillStyle="red"
	context.lineWidth = 2
	context.strokeStyle = "green"
	context.font = "8px batang"
	
	var bodynames =["코",
		"목", "오른쪽 어깨","오른쪽 팔꿈치",
		"오른쪽 손목","왼쪽 어깨","왼쪽 팔꿈치", "왼쪽 손목", "오른쪽 엉덩이",
		"오른쪽 무릎", "오른쪽 발목", "왼쪽 엉덩이", "왼쪽 무릎","왼쪽 발목", 
		"오른쪽 눈", "왼쪽 눈", "오른쪽 귀", "왼쪽 귀"	
	]
	//이미지 로드
	var image = new Image()
	image.src = "/faceimages/<%=image%>"
	image.onload = function(){
		context.drawImage(image, 10, 10, image.width, image.height)
		
		var sx, sy, ex, ey;
		for(var i in json.predictions){
			for(var j in json.predictions[i]){
				var body = json.predictions[i][j]
				var score = body.score
				var x = body.x
				var y = body.y
				resultdiv.innerHTML += j + " 신체부위 : x=" + x + ", y=" + y + "<br>"
				context.fillRect(x*image.width + 10, y*image.height + 10, 2, 2)
				
				//전체신체부위이름 출력
				//context.fillText(bodynames[j] + " : "+parseInt(score*100),x*image.width +10, y*image.height+10)
				
				//왼쪽 오른쪽 손목만 출력
				if(j=='4' || j=='7')
					context.fillText(bodynames[j] + " : "+parseInt(score*100),x*image.width +10, y*image.height+10)
				if(j=='4'){
					sx = x*image.width+ 10
					sy = y*image.height+ 10
				}
					
				if( j=='7'){
					ex = x*image.width+ 10
					ey = y*image.height+ 10
				} 
					
			}//for j end
		}//for i end
		//왼쪽 오른쪽 손목 선 연결
		context.beginPath()
		context.moveTo(sx, sy)
		context.lineTo(ex, ey)
		context.closePath()
		context.stroke()
		
	}//image onload end
	//var imagecanvas = $("#imagecanvas")//jquery객체타입
	//var context = imagecanvas.getContext("2d")

})
</script>
</head>
<body>
<h1>얼굴 인식 서비스</h1>
<div id="resultdiv"></div>
<h3>이미지 전체 캔버스</h3>
<canvas id="imagecanvas" width=600 height=800 style="border: 2px solid pink"></canvas>
</body>
</html>