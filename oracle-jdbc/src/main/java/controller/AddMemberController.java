package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/addMember")
public class AddMemberController extends HttpServlet {
	// 회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인전에만 진입가능
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
		if(loginMember != null) { // 이미 로그인 상태
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/member/addMember.jsp").forward(request, response);
	}
	
	// 회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
		if(loginMember != null) { // 이미 로그인 상태
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		request.setCharacterEncoding("UTF-8"); // 인코딩
		// form 에서 값 받기
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		System.out.println(memberId+"<-- AddMemberController memberId");
		System.out.println(memberPw+"<-- AddMemberController memberPw");
		System.out.println(memberName+"<--AddMemberController memberName");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		System.out.println(member+"<-- AddMemberController member");
		
		MemberService memberService = new MemberService();
		int row = memberService.addMember(member);
		if(row == 1) {
			System.out.println(row+"<-- row");
		}	
		// 뷰가 없다
		response.sendRedirect(request.getContextPath()+"/member/login");
	}

}
