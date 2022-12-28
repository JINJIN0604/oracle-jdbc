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


@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	// *loginForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	// 로그인전에만 진입가능
	HttpSession session = request.getSession();
	
	// 로그인 전 : loginMember -> null
	// 로그인 후 : loginMember -> not null	
	
	Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
	if(loginMember != null) { // 이미 로그인 상태
		response.sendRedirect(request.getContextPath()+"/member/login");
		return;
	}
	// 회원가입 view
	request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}
	

	// *loginAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 로그인전에만 진입가능
	HttpSession session = request.getSession();
	
	// 로그인 전 : loginMember -> null
	// 로그인 후 : loginMember -> not null
	
	Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
	if(loginMember != null) { // 이미 로그인 상태
		response.sendRedirect(request.getContextPath()+"/home");
		return;
	}
	
	String memberId = request.getParameter("memberId");
	String memberPw = request.getParameter("memberPw");
	
	Member paramMember = new Member(); // 위 값을 request 파라메터값으로 바인딩
	paramMember.setMemberId(memberId);
	paramMember.setMemberPw(memberPw);
	
	this.memberService = new MemberService();
	Member returnMember = memberService.login(paramMember);
	
	if(returnMember == null) { //로그인 실패
		response.sendRedirect(request.getContextPath()+"/home");
		return;
	}
	System.out.print("로그인 성공");
	session.setAttribute("loginMember", returnMember); // 로그인 세션 정보("loginMember", member타입)
	response.sendRedirect(request.getContextPath()+"/home");
	}

}
