package kr.ac.kopo.framework;

import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.controller.BoardDetailController;
import kr.ac.kopo.controller.BoardListController;
import kr.ac.kopo.controller.BoardWirterFormController;
import kr.ac.kopo.controller.BoardWriteController;
import kr.ac.kopo.controller.Controller;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/board/list.do", new BoardListController());
		mappings.put("/board/writeForm.do", new BoardWirterFormController());
		mappings.put("/board/write.do", new BoardWriteController());
		mappings.put("/board/detail.do", new BoardDetailController());
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri); 
	}
}
