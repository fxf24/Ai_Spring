package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("model", "hello spring~");
		return "hello.jsp";
	}

}
