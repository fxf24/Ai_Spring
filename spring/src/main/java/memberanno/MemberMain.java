package memberanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("memberanno/member.xml");
		//<context....."memberanno" - @어노테이션 찾아라
		
		MemberService service = factory.getBean("service", MemberService.class);
		
		service.login();
		service.register();
	}
}
