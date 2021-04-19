package ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAjaxController {
	
	@RequestMapping(value="/ajax/login", method=RequestMethod.GET)
	public String loginform() {
		return "/ajax/loginajax";
	}
	
	@RequestMapping(value="/ajax/login", method=RequestMethod.POST,
			produces={"application/json;charset=utf-8"})
	@ResponseBody//json데이터를 보낸다는 것을 명시
	public String loginresult(String id, String pw) {
		//"{\"변수명\":\"값\", ......}" json type
		System.out.println(id+":" + pw);
		String result = null;
		if(id.equals("spring") && pw.equals("spring")) {
			result = "{\"process\":\"정상로그인\", \"role\":\"admin\"}";
		}
		else {
			result = "{\"process\":\"비정상로그인\", \"role\":\"user\"}";	
		}
		System.out.println(result);
		return result;//json문자열형태
	}//loginresult end
	
	// /ajax/board?seq=?
//	@RequestMapping("/ajax/board")
//	@ResponseBody
//	public BoardDTO getBoardDTO(int seq) {
//		BoardDTO dto = new BoardDTO();
//		dto.setSeq(seq);
//		dto.setTitle("게시물제목");
//		dto.setContents("게시물내용");
//		dto.setWriter("작성자");
//		dto.setViewcount(1);
//		return dto;
//	}
	// /ajax/board/1 - url 내부값 사용 처리
	@RequestMapping("/ajax/board/{seq}")
	@ResponseBody
	public BoardDTO getBoardDTO(@PathVariable("seq") int seq) {
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle("게시물제목");
		dto.setContents("게시물내용");
		dto.setWriter("작성자");
		dto.setViewcount(1);
		return dto;
	}
	
	@RequestMapping("/ajax/boardlist")
	@ResponseBody
	public ArrayList<BoardDTO> getBoard(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO dto = new BoardDTO();
		dto.setSeq(1);
		dto.setTitle("게시물제목");
		dto.setContents("게시물내용");
		dto.setWriter("작성자");
		dto.setViewcount(100);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		return list;
	}
	
	
}
