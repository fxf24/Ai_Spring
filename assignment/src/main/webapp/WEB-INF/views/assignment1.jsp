<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <!-- 반응형 웹 만들기 -->
    <!-- 1. 모바일용 css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/test1_2.css" media="(max-width:600px)">
 
    <!-- 2. 데스크탑용 외부 스타일시트 적용 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/test1_1.css" media="(min-width:600px)">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#login_btn").on('click', function(){
		//$("#result").html("테스트완료")
		$.ajax({
			url: "<%=request.getContextPath()%>/login",
			data: {'id':$("#id").val(), 'pw':$("#pw").val()},
			type: 'post',
			dataType: 'json',
			//여기까지 서버에서 받아옴
			//밑에서부터 결과를 받아옴
			success: function(server){
				alert("Data:"+server.data + "\n"
					+"Status:"+server.status);
			}
		});//ajax 요청함수
	})//on end
});
</script>
</head>
<body>
 <div id="page">
 
        <header>
            <div id="logo">
                <img src="<%=request.getContextPath() %>/resources/imgs/logo.png" alt="Logo">
            </div>
 
            <div id="top_menu">
                <a href="#">HOME</a> | 
                <a href="#">NOTICE</a> |
<!--                 <a href="#">LOGIN</a> | -->
                <a href="#">JOIN</a> | 
                ID <input class="login" id="id"> PW <input type="password" class="login" id="pw"> <button id="login_btn">LOGIN</button>
            </div>
 
            <nav>
                <ul>
                    <li><a href="#">COMPANY</a></li>
                    <li><a href="#">PRODUCT</a></li>
                    <li><a href="#">CUSTOMER</a></li>
                    <li><a href="#">SERVICE</a></li>
                    <li><a href="#">RECRUIT</a></li>
                </ul>
            </nav>
 
        </header>
 
        <article id="content">
            <section id="main">
                <img id="main_img" src="<%=request.getContextPath() %>/resources/imgs/main_img.png" alt="main img" >
            </section>
            <section>
                <ul id="banner">
                    <li><a href="#"><img src="<%=request.getContextPath() %>/resources/imgs/banner1.png" alt="banner1"></a></li>
                    <li><a href="#"><img src="<%=request.getContextPath() %>/resources/imgs/banner2.png" alt="banner2"></a></li>
                </ul>
 
            </section>
            <section>
            	<div th:text="${message}"></div>
            </section>
 
        </article>
 
        <footer>
            <img id="address_img" src="<%=request.getContextPath() %>/resources/imgs/address.png" alt="address">
        </footer>
 
    </div>
</body>
</html>