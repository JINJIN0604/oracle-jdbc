package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
	private MemberService boardService;
			
	// 회원탈퇴 form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인전에만 접근가능 == null (로그인된 회원은 접근 금지)
		HttpSession session = request.getSession();
		// 로그인 전 이 값은 null
		// 로그인 후 로그인 한 값 (!=null)
		Member loginMember = (Member)session.getAttribute("loginMember"); 
		if(loginMember == null) { // 로그인 x -> 로그인폼 이동
			response.sendRedirect(request.getContextPath()+"/home"); //URL
			return;
		}
		// view
		request.getRequestDispatcher("/WEB-INF/view/member/removeMember.jsp").forward(request, response);
	}
	// 회원탈퇴 action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인전에만 접근가능 == null (로그인된 회원은 접근 금지)
		HttpSession session = request.getSession();
		// 로그인 전 이 값은 null
		// 로그인 후 로그인 한 값 (!=null)
		Member loginMember = (Member)session.getAttribute("loginMember"); 
		if(loginMember == null) { // 로그인 x -> 홈 이동
			response.sendRedirect(request.getContextPath()+"/member/login"); //URL
			return;
		}
		request.setCharacterEncoding("utf-8");// 인코딩
		// 폼에서 가져옴
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId+"<-- RemoveMemberController memberId");
		System.out.println(memberPw+"<-- RemoveMemberController memberPw");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println(member+"<-- RemoveMemberController member");
		
		MemberService memberService = new MemberService();
		int row = memberService.removeMember(member);
		System.out.println(row+"<--RemoveMemberController row");
		if(row == 1) {
			System.out.println(row+"<-- row");
		}
		// 뷰가 없다
		response.sendRedirect(request.getContextPath()+"/member/logout");
	}

}
