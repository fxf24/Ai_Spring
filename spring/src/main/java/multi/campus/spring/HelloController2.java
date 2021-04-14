package multi.campus.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController2{

	@RequestMapping("/hello2")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String[] title = {"게시물1", "게시물2", "게시물3"};
		mv.addObject("board", title);
		mv.setViewName("board");
		return mv;
	}

}
