package multi.campus.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {
	//crud - create read update delete
	//1개 여러개 오청 메소드를 다수개 정의
	//게시물 생성 조회 삭제 수정
	@RequestMapping("/crud/start")
	public void start() {
		//모델 없다
		//뷰이름 자동 결정 - /crud/start.jsp 자동결정
		
	}
	
	@RequestMapping("/crud/list")
	public ModelAndView list() {
		String[] title = {"게시물1","게시물2","게시물3"};
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", title);
		mv.setViewName("/crud/list");
		return mv;
	}
	
	@RequestMapping(value="/crud/add", method=RequestMethod.GET)
	public String addForm() {
		return "/crud/addform";
	}
	
	@RequestMapping(value="/crud/add", method=RequestMethod.POST)
	public ModelAndView addResult(String title, String contents, String writer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", title+":"+contents+":"+writer);
		mv.addObject("status", "게시물 1개 저장 완료");
//		mv.setViewName("/crud/add");
		return mv;
	}
	
	@RequestMapping(value="/crud/update", method=RequestMethod.GET)
	public ModelAndView updateForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "선택한 게시물 제목");
		mv.addObject("contents", "선택한 게시물 내용");
		mv.addObject("writer", "작성자");
		mv.setViewName("/crud/updateform");
		return mv;
	}
	
	@RequestMapping(value="/crud/update", method=RequestMethod.POST)
	public ModelAndView updateResult(String title, String contents, String writer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", title+":"+contents+":"+writer);
		mv.addObject("status", "게시물 1개 수정 완료");
//		mv.setViewName("/crud/update");
		return mv;
	}
	
	@RequestMapping(value="/crud/delete", method=RequestMethod.GET)
	public ModelAndView deleteForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("seq");
		mv.setViewName("/crud/deleteform");
		return mv;
	}
	@RequestMapping(value="/crud/delete", method=RequestMethod.POST)
	public ModelAndView delete(String seq) {
		ModelAndView mv = new ModelAndView();
		System.out.println(seq + "번의 글 삭제");
		mv.addObject("seq", seq);
		mv.setViewName("redirect:/crud/list");
		//return "/crud/list"; //view이름 이동(model 없다)
		return mv;//url 매핑 메소드 이동(model 있다)
	}
}
