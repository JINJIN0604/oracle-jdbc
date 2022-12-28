package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	// 검색 추가
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTitle, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, createdate"
				+ "			FROM (SELECT board_no, board_title, createdate"
				+ "					FROM board ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum >=? AND rnum <=?;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		return list;
	}

	// 상세페이지 boardOne
	public Board boardOne(Connection conn, int boardNo) throws Exception { 
		Board b = new Board();
		String sql = "SELECT board_title boardTitle, board_content boardContent, member_id memberId, updatedate, createdate FROM board WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			b = new Board(boardNo, rs.getString("boardTitle"), rs.getString("boardContent"), rs.getString("memberId"), rs.getString("updatedate"), rs.getString("createdate"));
		}
		return b;
	}
	
	// 글 추가  addBoard
	public int addBoard(Connection conn, Board board) throws Exception {
		int row = 0;
		String sql="INSERT INTO board(board_no, board_title, board_content, member_id, updatedate, createdate) VALUES (board_seq.nextval,?,?,?,sysdate,sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());

		// 디버깅 
		row = stmt.executeUpdate();
		if(row == 1) {
			System.out.println("추가성공");
			return 1;
		} else {
			System.out.println("추가실패");
		}
		return row;
	}
	
	// 글 수정
	public int modifyBoard(Connection conn, Board board) throws Exception {
		int row = 0;
		String sql = "UPDATE board SET board_title=?, board_content=?, WHERE board_No=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		// 디버깅 
		row = stmt.executeUpdate();
		if(row == 1) {
			System.out.println("입력성공");
			return 1;
		} else {
			System.out.println("입력실패");
		}
		return row;
	
	// 글 삭제
	
	
	
	
	
	
	/*
public int insertBoard(Connection conn, Board board) throws SQLException { // board 추가
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO board (board_no, board_title, board_content, member_id, updatedate, createdate) VALUES (board_seq.nextval,?,?,?,sysdate,sysdate)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		row = stmt.executeUpdate();
		stmt.close();
		return row;
	}
	public int updateBoard(Connection conn, Board board) throws SQLException {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "UPDATE board SET(board_title=?, board_content=?, updatedate=sysdate)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		row = stmt.executeUpdate();
		stmt.close();
		return row;
	}
	public int deleteBoard(Connection conn, int boardNo) throws SQLException { // board 삭제
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM board WHERE board_no=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		row = stmt.executeUpdate();
		stmt.close();
		return row;
	}
	 */
}
}
