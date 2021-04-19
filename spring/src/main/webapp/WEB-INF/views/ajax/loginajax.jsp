<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#login").on('click', function(){
		//$("#result").html("테스트완료")
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/login",
			data: {'id':$("#id").val(), 'pw':$("#pw").val()},
			type: 'post',
			dataType: 'json',
			//여기까지 서버에서 받아옴
			//밑에서부터 결과를 받아옴
			success: function(server){
				alert(server.process);
				$("#result").html(server.role)
				if(server.process=='정상로그인'){
					$("#result").css("color", "blue")
				}
				else{
					$("#result").css("color", "red")
				}
			}
		});//ajax 요청함수
	})//on end
	<%-- $("#board").on('click', function(){
		//$("#result").html("테스트완료")
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/board",
			data: {'seq':$('#seq').val()},
			type: 'get',
			dataType: 'json',
			//여기까지 서버에서 받아옴
			//밑에서부터 결과를 받아옴
			success: function(server){
				$("#result2").append(server.seq + "<br>")
				$("#result2").append(server.title + "<br>")
				$("#result2").append(server.contents + "<br>")
				$("#result2").append(server.writer + "<br>")
				$("#result2").append(server.viewcount + "<br>")
				
			}
		});//ajax 요청함수
	})//on end --%>
	$("#board").on('click', function(){
		//$("#result").html("테스트완료")
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/board/" + $("#seq").val(),
			type: 'get',
			dataType: 'json',
			//여기까지 서버에서 받아옴
			//밑에서부터 결과를 받아옴
			success: function(server){
				$("#result2").append(server.seq + "<br>")
				$("#result2").append(server.title + "<br>")
				$("#result2").append(server.contents + "<br>")
				$("#result2").append(server.writer + "<br>")
				$("#result2").append(server.viewcount + "<br>")
				
			}
		});//ajax 요청함수
	})//on end
	
	$("#boardlist").on('click', function(){
		//$("#result").html("테스트완료")
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/boardlist",
			type: 'get',
			dataType: 'json',
			//여기까지 서버에서 받아옴
			//밑에서부터 결과를 받아옴
			success: function(server){//server="ArrayList<BoardDTO> 를 json 배열 변경 자동"
				//[{seq:1,title:"",,},{},{},{}]
				for(var i in server){
					$("#result3").append("<div style='border:2px solid pink'>" +server[i].seq + "<br>")
					$("#result3").append(server[i].title + "<br>")
					$("#result3").append(server[i].contents + "<br>")
					$("#result3").append(server[i].writer + "<br>")
					$("#result3").append(server[i].viewcount + "<br></div>")
				}
			}
		});//ajax 요청함수
	})//on end
});//ready end
</script>
</head>
<body>
<h1>ajax 로그인 폼</h1>
<form action="">
<!-- 서버로 전송 - request.getParameter("id") 
	 jquery 전송 - id속성 = $("#id")
-->
아이디 <input type=text name="id" id="id"><br>
암호 <input type=password name="pw" id="pw"><br>
</form>
<button id="login">ajax로그인</button>
<div id="result"></div>

<input type=text id="seq"><button id="board">번 글 요청</button>
<div id=result2></div>

<button id="boardlist">글 요청</button>
<div id=result3></div>
</body>
</html>