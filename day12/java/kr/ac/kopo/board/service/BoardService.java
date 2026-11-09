package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {

	void addBoard(BoardVO board);
	List<BoardVO> getBoardList();
	BoardVO getBoardByNo(int no);
}
