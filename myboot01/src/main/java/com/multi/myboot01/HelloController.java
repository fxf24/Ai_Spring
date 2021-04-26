package com.multi.myboot01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	//@ResponseBody
	public String test() {
		return "hello";
	}
}
//spring mvc project ==== servlet-context.xml 파일 설정/web-inf/views/*.jsp
/*                        http://ip:port/컨텍스트명/매핑uri
 *                        기본 view jsp
 * 
 * spring boot === http://ip:port/매핑uri
 *                 http://127.0.0.1:9091/uri
 *                 기본 view jsp 아니다
 *                 1> src/main/webapp/WEB-INF/views폴더 생성
 *                 2> hello.jsp 생성
 *                 3> application.properties - 설정
 *                 4> pom.xml - jsp 사용 라이브러리 다운로드 설정
 *                 
 * */
 