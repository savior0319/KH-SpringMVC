package org.kh.member.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private Map<String, Controller> mappings;

	// 생성자를 통해 컨트롤러를 미리 생성 해놓고 매핑값을 넣어둠
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginControllerImpl());
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
