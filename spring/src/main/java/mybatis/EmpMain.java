package mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {
	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
		SqlSessionFactory factory =  builder.build(Resources.getResourceAsReader("mybatis/db-config.xml"));
		SqlSession session = factory.openSession(true);
		//bean태그 없다 @Component
		EmpService service = new EmpServiceImpl();
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);
		((EmpServiceImpl)service).setDao(dao);
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
		
		EmpVO vo = new EmpVO
				(-1, "사원", "김", "kim@a.com", "010222333", "IT_PROG", 100, 30000, 50);
		service.insertEmp2(vo);
		System.out.println("1명 사원 저장 완료");
		
		EmpVO vo2 = service.getOneEmp(1);
		System.out.println(vo2);
	}
}

