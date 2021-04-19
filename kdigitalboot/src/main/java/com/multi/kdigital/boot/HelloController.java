package com.multi.kdigital.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
//	@RequestMapping("/hello.boot")
//	public ModelAndView hello() {
//		ModelAndView m = new ModelAndView();
//		m.addObject("model", "hello boot~");
//		m.setViewName("name");
//		return m;
//	}
	
	@RequestMapping("/") //부트 http://localhost:9090
	public ModelAndView hello() {
		ModelAndView m = new ModelAndView();
		m.addObject("model", "hello boot~");
		m.setViewName("name");
		return m;
	}
}
