package project_test;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.myboot01.UploadVO;

@Controller
public class UploadController2 {
	@Autowired
	NaverObjectDetection2 odservice;
	
	@RequestMapping(value="/projecttest", method=RequestMethod.GET)
	public String uploadform() {
		return "/project_test/uploadform";
	}
	
	@RequestMapping(value="/projecttest", method=RequestMethod.POST)
	public ModelAndView uploadresult(@ModelAttribute("vo")  UploadVO vo) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadvo", vo);
		MultipartFile multipartfile1 = vo.getFile1();

		System.out.println(multipartfile1.getOriginalFilename());
		
		//업로드한 파일명 추출(=클라이언트원본파일명)
		String filename1 = multipartfile1.getOriginalFilename();
		//서버 저장 경로 설정
		String savePath="c:/upload/";
		
		//서버저장파일명(uuid중복방지)(클라이언트원본파일명).확장자
		
		// 중복파일처리1 : 
		// api : 랜덤암호화변경이름
		// a.txt --> 123wsdjhfckdjf.txt
		
		File file1 = new File(savePath + filename1);
		
		multipartfile1.transferTo(file1);
		//return "/upload/uploadresult";//뷰에서 업로드 파일명 출력 ???
		String result = odservice.test(filename1);
		System.out.println(filename1 +":" + result);
		mv.addObject("image", filename1);
		mv.addObject("odResult", result);
		mv.setViewName("/project_test/od");
		
		return mv; //ajax 클라이언트 {"a":"b"}
	}
}
