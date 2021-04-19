package ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Ajax 요청 처리 전용 컨트롤러
@RestController
public class AllAjaxController {
	
	@RequestMapping("/a")
	//@ResponseBody
	public BoardDTO a() {
		return new BoardDTO();
	}
	
	@RequestMapping("/b")
	//@ResponseBody
	public String b() {
		return "{}";
	}
	@RequestMapping("/c")
	//@ResponseBody
	public int c() {
		return 0;
	}
	
}
