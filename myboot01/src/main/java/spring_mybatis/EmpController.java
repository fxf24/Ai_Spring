package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	//employees 테이블 전체 조회
	@RequestMapping("/emplist")
	public ModelAndView getEmpList(){//page 변수 전달값이 보여줄 페이지. 한페이지당 출력갯수 10개
		//mybatis SqlSession -- EmpDAO -- EmpService하위 - EmpMain
		List<EmpVO> list = service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
		mv.setViewName("/mybatis/emplist");
		return mv;
	}
	
	//employees테이블 page 변수 전달값이 보여줄 페이지.한페이지당 출력 갯수 10개. 입사일이 빠른 사원부터 출력
	@RequestMapping("/emplistpage")
	public ModelAndView getEmpPage(int page){//page 변수 전달값이 보여줄 페이지. 한페이지당 출력갯수 10개
		int[] pages = {(page-1)*10 +1, (page-1)*10 +11};
		
		List<EmpVO> list = service.getEmpPage(pages);
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
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
	
	
	
	//추가펌 출력 / 사원정보 입력 - db insert - emplist뷰
	//employee_id, email - 중복x,
	//last_name not null
	//job_id, department_id, manager_id - 외래키
	
	@RequestMapping(value="/empadd", method=RequestMethod.GET)
	public String addEmp() {
		return "/mybatis/addform";
	}
	
	@RequestMapping(value="/empadd", method=RequestMethod.POST)
	public String addEmp2(EmpVO vo) {
		System.out.println(vo.toString());
		service.registerEmp(vo);
		
		return "redirect:/emplist";
	}
	
	//수정
	@RequestMapping(value="/empmodify", method=RequestMethod.GET)
	public ModelAndView modifyEmp(int id) {
		ModelAndView mv = new ModelAndView();
		EmpVO vo = service.getOneEmp(id);
		mv.addObject("emp",vo);
		mv.setViewName("/mybatis/modifyform");
		return mv;
	}
	
	@RequestMapping(value="/empmodify", method=RequestMethod.POST)
	public String modifyEmp(EmpVO vo) {
		
		return "redirect:/emplist";
	}
	
	//삭제
	@RequestMapping(value="/empdelete", method=RequestMethod.GET)
	public String deleteEmp(int id) {
		
		return "redirect:/emplist";
	}
}
