package naver.cloud;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NaverController {
	@Autowired
	NaverFaceService service;
	@Autowired
	NaverFaceService2 service2;
	@Autowired
	NaverOCRService ocrservice;
	@Autowired
	NaverObjectDetection odservice;
	@Autowired
	NaverPoseService poseservice;
	@Autowired
	NaverSpeechService speechservice;
	@Autowired
	NaverVoiceService voiceservice;
	
	@RequestMapping("/faceinput")
	public ModelAndView faceinput() {
		// \images 폴더를 file 객체 생성
		// file 객체 list 메소드 이용하면 파일 이름만 배열 리턴
		// 리턴받은 배열을 모델 생성 - 모델명 filelist
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/faceinput");
		//faceinput.jsp구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/face 호출하면서 파일이름 전달">파일이름 </a>
		return mv;
	}
	
	@RequestMapping(value = "/face", method = RequestMethod.GET)
	public ModelAndView face(String image) {
		String result = service.test(image);
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("faceResult", result);
		mv.setViewName("/naver/face");
		return mv;
	}
	
	@RequestMapping("/faceinput2")
	public ModelAndView faceinput2() {
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/faceinput2");
		return mv;
	}
	@RequestMapping(value = "/face2", method = RequestMethod.GET)
	public ModelAndView face2(String image) {
		String result = service2.test(image);
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("faceResult", result);
		mv.setViewName("/naver/face3");
		return mv;
	}
	
	@RequestMapping("/ocrinput")
	public ModelAndView ocrinput() {
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/ocrinput");
		return mv;
	}
	@RequestMapping(value = "/ocr", method = RequestMethod.GET)
	public ModelAndView ocr(String image) {
		String result = ocrservice.test(image);
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ocrResult", result);
		mv.setViewName("/naver/ocr");
		return mv;
	}
	
	@RequestMapping("/odinput")
	public ModelAndView odinput() {
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/odinput");
		return mv;
	}
	@RequestMapping(value = "/od", method = RequestMethod.GET)
	public ModelAndView od(String image) {
		String result = odservice.test(image);
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("odResult", result);
		mv.setViewName("/naver/od");
		return mv;
	}
	
	@RequestMapping("/poseinput")
	public ModelAndView poseinput() {
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/poseinput");
		return mv;
	}
	@RequestMapping(value = "/pose", method = RequestMethod.GET)
	public ModelAndView pose(String image) {
		String result = poseservice.test(image);
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("poseResult", result);
		mv.setViewName("/naver/pose");
		return mv;
	}
	
	@RequestMapping("/speechinput")
	public ModelAndView speechinput() {
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/speechinput");//image=mp3파일 & lang=언어
		return mv;
	}
	@RequestMapping(value = "/speech", method = RequestMethod.GET)
	public ModelAndView speech(String image, String lang) {
		String result = "";
		if(lang == null) {
			result = speechservice.test(image);
		}
		else {
			result = speechservice.test(image, lang);
		}
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("speechResult", result);
		mv.setViewName("/naver/speech");
		return mv;
	}
	
	@RequestMapping("/voiceinput")
	public ModelAndView voiceinput() {
		File f = new File("C:/python_source/images");
		String[] filelist = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/voiceinput");//image=mp3파일 & lang=언어
		return mv;
	}
	@RequestMapping(value = "/voice", method = RequestMethod.GET)
	public ModelAndView voice(String image, String speaker) {
		String result;
		if(speaker == null) {
			result = voiceservice.test(image);
		}
		else {
			result = voiceservice.test(image, speaker);
		}
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("voiceResult", result);
		mv.setViewName("/naver/voice");
		return mv;
	}
}
