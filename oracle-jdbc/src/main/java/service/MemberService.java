package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	
	//로그인
	public Member login(Member paramMember) {
		Member resultMember = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.memberDao = new MemberDao();
			resultMember = memberDao.login(conn, paramMember);
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
		return resultMember;
	}
	
	//회원가입
	public int addMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.memberDao = new MemberDao();
			row = memberDao.addMember(conn, member);
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
	//회원탈퇴
	public int removeMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.memberDao = new MemberDao();
			row = memberDao.removeMember(conn, member);
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
	// 회원정보수정
	public int modifyMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.memberDao = new MemberDao();
			row = memberDao.modifyMember(conn, member);
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