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
<h1>얼굴 인식 서비스</h1>
<!-- // 1개의 얼굴을 감지한 경우
{
 "info": {
   "size": {
     "width": 900,
     "height": 1349
   },
   "faceCount": 1
 },
 "faces": [{
   "roi": {
     "x": 235,
     "y": 227,
     "width": 326,
     "height": 326
   },
   "landmark": {
     "leftEye": {
       "x": 311,
       "y": 289
     },
     "rightEye": {
       "x": 425,
       "y": 287
     },
     "nose": {
       "x": 308,
       "y": 346
     },
     "leftMouth": {
       "x": 306,
       "y": 425
     },
     "rightMouth": {
       "x": 383,
       "y": 429
     }
   },
   "gender": {
     "value": "male",
     "confidence": 0.91465
   },
   "age": {
     "value": "22~26",
     "confidence": 0.742265
   },
   "emotion": {
     "value": "simile",
     "confidence": 0.460465
   },
   "pose": {
     "value": "frontal_face",
     "confidence": 0.937789
   }
 }]
}

// 감지한 얼굴이 없을 경우
{
 	"info": {
 		"size": {
 			"width": 700,
 			"height": 800
 		},
 		"faceCount": 0
 	},
 	"faces": []
 }
 -->

<%
String faceResult = (String)request.getAttribute("faceResult");

JSONObject obj = new JSONObject(faceResult);
Object imsi = obj.get("faces");
JSONArray faces = (JSONArray)imsi;
boolean find = false;

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
	
}

String image = request.getParameter("image");
if(!find){
	out.println("얼굴을 찾을 수 없습니다.");
}
%>
<img src="/faceimages/<%=image%>">
</body>
</html>