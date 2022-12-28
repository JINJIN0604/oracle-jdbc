package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	// 회원 정보 수정
	
	// 회원탈퇴
	public int removeMember(Connection conn, Member member) throws Exception {
		int row = 0;	

		String sql = "DELETE FROM member WHERE member_id=? AND member_pw=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		row = stmt.executeUpdate();
		return row; 
	}
	
}
