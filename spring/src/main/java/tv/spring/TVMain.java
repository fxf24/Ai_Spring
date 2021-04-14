package tv.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		// spring 설정 객체 주임 설정 파일 읽어옴
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("tv/spring/tv.xml");
		
		TV tv = factory.getBean("tv", TV.class);
			
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		TV tv2 = factory.getBean("tv2", TV.class);
		
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
		
	}
	

}
