package naver.chatbot;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.multi.myboot01.UploadVO;

@Controller
public class NaverChatbotController {
	@Autowired
	NaverChatbotService chatbotservice;
	@Autowired
	@Qualifier("chatbotspeechService")
	NaverSpeechService speechservice;//2개(naver.cloud, naver.chatbot패키지)
	
	@Autowired
	@Qualifier("chatbotvoiceservice")
	NaverVoiceService voiceservice;//2개(naver.cloud, naver.chatbot패키지)
	
	
	@RequestMapping("/chatbotstart")
	public String chatbotstart() {
		return "/naver/chatbot/chatbotstart";
	}
	
	@RequestMapping("/chatbot")
	@ResponseBody
	public String chatbot(String message){
		//질문받아서 네이버 서버 호출 - 답변 내용 리턴
		String event = null;
		if(message == "") {
			event = "open";
		}
		else {
			event = "send";
		}
		String response = chatbotservice.test(message, event);	
		System.out.println(response);
		return response;
	}
	
	@RequestMapping(value="/mp3upload", method=RequestMethod.POST)
	@ResponseBody
	public String uploadresult(MultipartFile file) throws IOException {
		//업로드한 파일명 추출(=클라이언트원본파일명)
		String filename = file.getOriginalFilename();
		//서버 저장 경로 설정
		String savePath="c:/upload/";
		//저장할 경로와 파일 이름 완성
		File savefile = new File(savePath + filename);
		//서버 저장
		file.transferTo(savefile);
		return "잘 받았습니다"; //ajax 클라이언트 {"a":"b"}
	}
	
	//STT - 음성 질문 요청
	@RequestMapping("/chatbotspeech")
	@ResponseBody
	public String speech(String mp3file, String lang) {
		String result = speechservice.test(mp3file);
		return result;
	}
	
	//TTS - 음성 답변 응답
	@RequestMapping("/chatbotvoice")
	@ResponseBody
	public String voice(String text, String speaker) {
		String result = voiceservice.test(text, speaker);
		return result;
	}
	
}
