package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	//employees 테이블 전체 조회
	@RequestMapping("/emplist")
	public ModelAndView getEmpList(){
		//mybatis SqlSession -- EmpDAO -- EmpService하위 - EmpMain
		List<EmpVO> list = service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardlist", list);
		mv.setViewName("/mybatis/emplist");
		return mv;
	}
	
	//employees 테이블 - 1개 레코드 조회
	//model로 생성
	// /mabatis/empdetail.jsp
	
	@RequestMapping("/empdetail")
	public ModelAndView getOneEmp(int id) {
		EmpVO vo = service.getOneEmp(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empdetail", vo);
		mv.setViewName("/mybatis/empdetail");
		return mv;
	}
	
	
	
	//추가 수정 삭제
	
}
