package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("memberservice/member.xml");
		
		MemberService service =  factory.getBean("service", MemberService.class);
		
		service.login();
		service.register();
	}
}
