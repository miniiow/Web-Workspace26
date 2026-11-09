package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {

	/**
	 * 게시글 저장
	 */
	void save(BoardVO board);
	
	/**
	 * 전체게시글 조회
	 */
	List<BoardVO> findAll();
	
	/**
	 * 게시판번호를 이용한 상세게시글 조회
	 */
	BoardVO findByNo(int no);
}
