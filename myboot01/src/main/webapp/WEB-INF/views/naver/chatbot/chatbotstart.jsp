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
	$("#enter").on('click', function(){
		$("#chatbox").css("display", "block")
		//웰컴메시지 보여줘
		//질문 입력 -답변 출력해줘
		send()
	})
	$("#exit").on('click', function(){
		$("#chatbox").css("display", "none")
	})
});//ready end

function send(){
	var inputMessage = $("#inputMessage").val()
	if(inputMessage != ""){
		$("#messageWindow").append("<div><span style='background-color:yellow;float:right;margin:0px 10px 10px 0px;border-radius:5px;'>나 : " + inputMessage + "</span></div><br>")
	}
	
	$.ajax({
		url : "/chatbot",
		type : "post",
		data : {"message" : inputMessage},//입장만 하면 질문없다(컨트롤러는 웰컴메시지 출력)
		dataType : 'json',
		success : function(server_response){//웰컴메시지 or 실패메시지 or 정상메시지
			//$("#messageWindow").text(JSON.stringify(server_response) + "<br>")
			var bubbles = server_response.bubbles
			for(var b in bubbles){
				if(bubbles[b].type == 'text'){//텍스트 답변 처리 시작
					$("#messageWindow").append("<div><span style='background-color:white;float:left;margin:0px 0px 10px 10px;border-radius:5px;'>chatbot : " +bubbles[b].data.description + "</span></div><br><br>")
					$.ajax({
						url:'/chatbotvoice',
						type:'post',
						data:{"text":bubbles[b].data.description, "speaker":"mijin"},
						success: function(mp3){
							$("#voice").attr('src', "/projecttest/"+mp3)
							var audio = $("#voice").get(0)
							audio.play()
						}
					})
					if(bubbles[b].data.url != null){
						$("#messageWindow").append
						("<div><span style='background-color:white;float:left;margin:0px 0px 10px 10px;border-radius:5px;'>chatbot : <a href='" +bubbles[b].data.url + "'>" +bubbles[b].data.url + "</a></span></div><br><br>")
					}//url 있으면 if end
				}//if end
				else if(bubbles[b].type=='template'){//이미지 버튼 멀티링크
					//이미지-이미지로 출력
					if(bubbles[b].data.cover.type=='image'){
						$("#messageWindow").append
						("<img src='" + bubbles[b].data.cover.data.imageUrl+ "'><br><br>")
					}
					//멀티링크 답변 - 텍스트로 출력
					else if(bubbles[b].data.cover.type=='text'){
						$("#messageWindow").append
						("<div><span style='background-color:white;float:left;margin:0px 0px 10px 10px;border-radius:5px;'>chatbot : " +bubbles[b].data.cover.data.description + "</span></div><br><br>")
					}
					//공통 == contentTable 배열 변수 포함. 링크이름 버튼이름 링크 url 버튼 url
					for(var ct in bubbles[b].data.contentTable){
						var ctdata = bubbles[b].data.contentTable[ct]
						for(var ctdataindex in ctdata){
							var linkurl = ctdata[ctdataindex].data.data.action.data.url
							var linktitle = ctdata[ctdataindex].data.title
						}
						$("#messageWindow").append
						("<div><span style='background-color:white;float:left;margin:0px 0px 10px 10px;border-radius:5px;'>chatbot : <a href='" +linkurl + "'>" + linktitle + "</a></span></div><br><br>")
					}
				}//else if end template
				
			}
			
			
		},
		error : function(){
			
		}
	})//ajax end
	$("#inputMessage").val("")
	
	//jqeurty 객체를 자바스크립트 객체 변환
	var obj = $("#messageWindow").get(0);
	//자동 스크롤 아래로.
	obj.scrollTop = obj.scrollHeight;
}//send end

function enterkey(){
	//엔터키 입력(a - 97 0-48 엔터키 - 13)하면 send 함수 동일 효과
	if(window.event.keyCode == 13){
		send()
	}
}//enterkey end
</script>

</head>
<body>
<button id="enter">입장</button>&nbsp;&nbsp;<button id="exit">퇴장</button>
<div id="chatbox" style="display:none;">
	<div id="messageWindow" style="background-color:#adcdef;width:500px;height:600px;overflow:scroll;" ></div>
	<input id="inputMessage" type=text style="width:400px" onkeyup=enterkey()	>
	<input type=submit value=send onclick="send()">
	<button id="rec_start">녹음</button><button id="rec_stop">정지</button>
	<audio id="voice" src="" controls="controls"></audio>
</div>
<script >
//녹음 정지 기능 구현
		const record = document.getElementById("rec_start")
        const stop = document.getElementById("rec_stop")
        //const soundClips = document.getElementById("sound-clips")

        if (navigator.mediaDevices) {
            console.log('getUserMedia supported.')
            const constraints = {
                audio: true
            }
            let chunks = []
            navigator.mediaDevices.getUserMedia(constraints)
                .then(stream => {
                    const mediaRecorder = new MediaRecorder(stream)
                    record.onclick = () => {
                        mediaRecorder.start()
                        console.log(mediaRecorder.state)
                        console.log("recorder started")
                        record.style.background = "red"
                        record.style.color = "black"
                    }
                    stop.onclick = () => {//정지 버튼 클릭시에
                        mediaRecorder.stop()//녹음 정지시켜라
                        console.log(mediaRecorder.state)
                        console.log("recorder stopped")
                        record.style.background = ""
                        record.style.color = ""
                    }
					//녹음 정지시킨 상태가 되면 실행하라
                    mediaRecorder.onstop = e => {
                        console.log("data available after MediaRecorder.stop() called.")
                        const clipName = "mictest"+new Date().getTime().toString().substring(10);
						//audio 태그 만들어라
                        const audio = document.createElement('audio')
 						//a태그 만들어라
 						const a = document.createElement('a')
                        //controls 속성 만들어라
                        audio.setAttribute('controls', '')
                        audio.controls = true
                        //auido  태그를 sound-clips에 포함하라 
                       // soundClips.appendChild(audio)
                        //a 태그를 sound-clips에 포함하라
                       // soundClips.appendChild(a)
                        //chunks에 저장된 녹음 데이터를 audio 양식으로 만들어라
                        const blob = new Blob(chunks, {
                            'type': 'audio/mp3'
                        })
                        chunks = []
                        const audioURL = URL.createObjectURL(blob)
                        audio.src = audioURL
                        
                        //파일 저장
                        /* a.href=audioURL//녹음데이터 url
                        a.download = clipName
                        a.innerHTML = "MP3로 저장"
                         */
                        //내 스프링 서버 녹음 데이터 업로드
                        //자바스크립트FormData 객체 - <form multi... 
                        //<input type=file name="f1"
                        var formData = new FormData()//form
						formData.append("file", blob, clipName+".mp3")//input
						$.ajax({
							url:'/mp3upload',
							type:'post',
							data:formData,
							processData:false,
							contentType:false,
							success:function(response){
								$.ajax({
									url:'/chatbotspeech',
									type:'get',
									data:{"mp3file": clipName+".mp3", "lang":"kor"},
									success:function(res){
										var resjson = JSON.parse(res)
										$("#inputMessage").val(resjson.text)
									}
								})
							}
						})
                        
						//chatspeech
                    }//mediaRecorder.onstop

                    //녹음 시작시킨 상태가 되면 chunks에 녹음 데이터를 저장하라 
                    mediaRecorder.ondataavailable = e => {
                        chunks.push(e.data)
                    }
                })
                .catch(err => {
                    console.log('The following error occurred: ' + err)
                })
        }
</script>
</body>
</html>