package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("member/member.xml");
		MemberVO vo = factory.getBean("vo",MemberVO.class);
		
		MemberDAO dao = factory.getBean("dao",MemberDAO.class);

		boolean login = dao.selectMember();
		if(login) {
			System.out.println("정상 로그인 사용자");
		}
		dao.insertMember();
	}
}
