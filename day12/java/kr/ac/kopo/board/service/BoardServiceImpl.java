package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.dao.BoardDAOImpl;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDAOImpl();
	}
	
	@Override
	public void addBoard(BoardVO board) {
		boardDao.save(board);
	}

	@Override
	public List<BoardVO> getBoardList() {
		
		return boardDao.findAll();
	}

	@Override
	public BoardVO getBoardByNo(int no) {

		return boardDao.findByNo(no);
	}

}
