package emp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("emp/spring/emp.xml");
		
		VO vo = factory.getBean("vo", VO.class);
		VO vo2 = factory.getBean("vo2", VO.class);
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		dao.insertEmp(vo);
		dao.insertEmp(vo2);
		
		System.out.println("등록이 완료되었습니다.");
		
	}

}
