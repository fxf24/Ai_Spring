package com.assign.ment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginform() {
		return "/assignment1";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST,
			produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String loginresult(String id, String pw) {
	//	{'Data':$("#id").val() + "님 login ok", 'Status':'success'}
		String result = "{\"data\": \"" + id + "님 loginok\", \"status\":\"success\"}";
		return result;
	}
}
