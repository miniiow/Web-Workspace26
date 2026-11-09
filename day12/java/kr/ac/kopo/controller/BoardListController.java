package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.service.BoardServiceImpl;
import kr.ac.kopo.board.vo.BoardVO;

// Dispatcher Servlet에서 전달한 request, response을 받아야 함
public class BoardListController implements Controller{
	
//	 @return 응답할 jsp 파일명(응답할 jsp파일의 경로를 return 한다)
//	 handRequest : 요청을 받아서 처리하는 역할
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardService boardService = new BoardServiceImpl();
		List<BoardVO> boardList = boardService.getBoardList();
		
//		jsp가 볼 reqeust 공유영역에 등록
		request.setAttribute("boardList", boardList);
		return "/board/list.jsp";
	}
}