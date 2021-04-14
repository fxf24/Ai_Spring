package test;

import java.util.HashMap;



public class HandlerMapping {
	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello.mvc", new HelloController());
	}
	public Controller getController(String name){
		return mappings.get(name);
	}
}
