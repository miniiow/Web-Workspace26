package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
/**
 * ORACLE DB에서 t_board 게시판 CRUD
 */
public class BoardDAOImpl implements BoardDAO {

	@Override
	public void save(BoardVO board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1, 2단계
			conn = new ConnectionFactory().getConnection();
			// 3단계
			String sql  = "insert into t_board(no, title, writer, content) ";
			       sql += " values(seq_t_board_no.nextval, ?, ?, ?) ";
			       
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			// 4단계
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계
			JDBCClose.close(conn, pstmt);
		}
		
		
	}

	@Override
	public List<BoardVO> findAll() {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			// 3단계
			String sql  = "select no, title, writer, reg_date ";
			       sql += "  from t_board ";
			       sql += " order by no desc ";
			       
			pstmt = conn.prepareStatement(sql);
			
			// 4단계
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 컬럼 추출
				int    no    	= rs.getInt("no");
				String title 	= rs.getString("title");
				String writer	= rs.getString("writer");
				String regDate	= rs.getString("reg_date");
				
				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				
				// 리스트 추가
				boardList.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return boardList;
	}

	@Override
	public BoardVO findByNo(int boardNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			// 3단계
			String sql  = "select no, title, writer, content, view_cnt, reg_date ";
				   sql += "  from t_board ";
				   sql += " where no = ? ";
				   
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			// 4단계
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setContent(content);
				board.setViewCnt(viewCnt);
				board.setRegDate(regDate);
				
				return board;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return null;
	}
}













