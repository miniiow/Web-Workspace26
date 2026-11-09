package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.BoardDetailController;
import kr.ac.kopo.controller.BoardListController;
import kr.ac.kopo.controller.BoardWirterFormController;
import kr.ac.kopo.controller.Controller;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private HandlerMapping mappings = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		mappings = new HandlerMapping();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		System.out.println("contextPath : " + context);
		String uri = request.getRequestURI();
		System.out.println("요청 uri : " + uri);
		
		uri = uri.substring(context.length());
		
		try {
			Controller control = mappings.getController(uri);
			
			String callPage = control.handleRequest(request, response);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
}
