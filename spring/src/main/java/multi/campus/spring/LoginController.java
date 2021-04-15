package multi.campus.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	//1. 로그인폼 출력
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginform() {
		//모델값 없다
		return "loginform";//뷰어를 리턴
	}
	
	@RequestMapping(value="/login",  method=RequestMethod.POST)
	//2. 입력내용 로그인처리결과 출력
	public ModelAndView loginresult(@ModelAttribute("vo")LoginVO vo) {//vo변수명 = 파라미터명 자동 주입
		ModelAndView mv = new ModelAndView();
		System.out.println(vo.getId() + ":" + vo.getPw());
		if(vo.getId().equals("spring") && vo.getPw().equals("work")) {
			mv.addObject("result", "정상 로그인 사용자");
		}
		else {
			mv.addObject("result", "아이디 암호를 다시 입력하세요.");
		}
		mv.setViewName("loginresult");
		return mv;
	}
}
