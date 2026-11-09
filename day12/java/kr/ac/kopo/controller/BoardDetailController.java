package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.service.BoardServiceImpl;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardDetailController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		BoardService boardService = new BoardServiceImpl();
		int a = Integer.parseInt(request.getParameter("no"));
		BoardVO boardByNo = boardService.getBoardByNo(a);
		
		request.setAttribute("board", boardByNo);
		return "/board/detail.jsp";
	}
}
