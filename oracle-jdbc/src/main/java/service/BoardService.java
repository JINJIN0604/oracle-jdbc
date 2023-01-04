package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;

public class BoardService {
	private BoardDao boardDao;
	
	public ArrayList<Board> getBoardListByPage(int currentPage, int rowPerPage, String search) {
		/*
		 	1) connection 생성 <- DBUtil.class
		 	2) beginRow, endRow 생성 <- currentPage,rowPerPage를 가공
		 */
		ArrayList<Board> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			int beginRow = (currentPage-1)*rowPerPage+1;
			int endRow = beginRow + rowPerPage - 1;
			boardDao = new BoardDao();
			list = boardDao.selectBoardListByPage(conn, beginRow, endRow, search);
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 상세페이지 boardOne
	public Board boardOne(int boardNo) {
		Board b = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			b = boardDao.boardOne(conn, boardNo); // model
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return b;
	}
	
	// 글추가 addBoard
	public int addBoard(Board board) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			row = boardDao.addBoard(conn, board);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 글수정
	public int modifyBoard(Board board, String memberId) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			row = boardDao.modifyBoard(conn, board, memberId);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 글삭제
	public int removeBoard(int boardNo, String memberId) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			row = boardDao.removeBoard(conn, boardNo, memberId);
			System.out.println(row + "<-- service row");
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}

