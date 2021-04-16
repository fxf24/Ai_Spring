package spring_mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring_mybatis/mybatis_spring.xml");
//		SqlSession session = factory.getBean("sqlSession", SqlSession.class);
//		System.out.println(session);
		//bean태그 없다 @Component
		EmpService service = factory.getBean("service", EmpService.class);
//		EmpDAO dao = new EmpDAO();
//		dao.setSession(session);
//		((EmpServiceImpl)service).setDao(dao);
		//test1: 1개 vo
//		EmpVO vo = service.getOneEmp(200);
//		System.out.println(vo);
		//test2 : 리스트
//		List<EmpVO> list = service.getAllEmp();
//		for(EmpVO vo : list) {
//			System.out.println(vo);
//		}
		
//		EmpVO vo = new EmpVO
//				(300, "사원", "김", "kim@a.com", "010222333", "IT_PROG", 100, 30000, 50);
//		service.insertEmp(vo);
//		System.out.println("1명 사원 저장 완료");
//		
//		EmpVO vo2 = service.getOneEmp(300);
//		System.out.println(vo2);
		
//		test4
//		//300사원의 이름을 대리로 변경
//		EmpVO vo3 = new EmpVO();
//		vo3.setEmployee_id(300);
//		vo3.setFirst_name("대리");
//		//service 추가메소드 - dao 추가메소드 - sql-mapping.xml
//		service.updateEmp(vo3);
//		
//		EmpVO vo4 = service.getOneEmp(300);
//		System.out.println(vo4);
//		test5
//		int employee_id = 300;
//		service.deleteEmp(employee_id);
		
		//test6 페이징처리
//		int[] nums = {11,20};
//		List<EmpVO> list = service.getPageEmp(nums);
//		for(EmpVO vo : list) {
//			System.out.println(vo);
//		}
		
		//test7
//		EmpVO vo = new EmpVO();
//		vo.setFirst_name("과장");
//		vo.setLast_name("김");
//		vo.setJob_id("IT_PROG");
//		vo.setDepartment_id(100);
//		vo.setEmail("kim5@kitridf.com");
//		vo.setPhone_number("010222222");
//		vo.setSalary(1000);
//		
//		service.insertEmp2(vo);
//		System.out.println("insert seq 저장 완료");
		
		//test8 - Arraylist
//		List<Integer> deptlist = new ArrayList<>();
//		deptlist.add(10);
//		deptlist.add(50);
//		deptlist.add(80);
//		deptlist.add(100);
//		List<EmpVO> list = service.getEmpDept(deptlist);
//		for(EmpVO vo : list) {
//			System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name() + ":"
//					+ vo.getDepartment_id());
//		}
		
		
		//test9 - HashMap
//		Map<String, String> map = new HashMap<>();
//		map.put("dept", "50");
//		map.put("email", "a2@bb.com");
//		map.put("id", "6");
//		
//		service.updateMap(map);
//		System.out.println("수정완료");
	}
}

