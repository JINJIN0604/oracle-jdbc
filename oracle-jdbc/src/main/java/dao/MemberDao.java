package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import vo.Member;

public class MemberDao {
	// 로그인 메서드
	public Member login(Connection conn, Member paramMember) throws Exception {
		Member resultMember = null;
		String sql = "SELECT member_id memberId, member_name memberName FROM MEMBER WHERE member_id = ? AND member_pw = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramMember.getMemberId());
		stmt.setString(2, paramMember.getMemberPw());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			// 로그인성공
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
		}
		return resultMember;
	}
	
	// 회원가입
	public int addMember(Connection conn, Member member) throws Exception{
		int row = 0;
		String sql ="INSERT INTO member(member_id, member_pw, member_name, updatedate, createdate) VALUES(?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		row = stmt.executeUpdate();
		return row;	// 성공하면 1
	}
	
	// 회원정보 수정
	public int modifyMember(Connection conn, Member member) throws Exception { // 회원정보 수정
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "UPDATE member SET member_name=? WHERE member_id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberName());
		stmt.setString(2, member.getMemberId());
		System.out.println(member+"<-- updateMember");
		row = stmt.executeUpdate();
		stmt.close();
		return row;
	}
	
	// 회원탈퇴
	public int removeMember(Connection conn, Member member) throws Exception {
		int row = 0;	
		String sql = "DELETE FROM member WHERE member_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		System.out.println(member+"<-- removeMember");
		row = stmt.executeUpdate();
		if(row == 1) {
			System.out.println("삭제 성공");
			return 1;
		}
		stmt.close();
		return row;
	}	
	//비밀번호 일치 확인
	public int checkMemberPw(Connection conn, String memberPw) throws Exception{
		int row = 0;
		String sql="SELECT member_id memberId, member_pw memberPw FROM member WHERE member_pw=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberPw);		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {	//비밀번호가 일치한다면
			row = 1;
		}	
		rs.close();
		stmt.close();
		conn.close();
		return row;
	}
}