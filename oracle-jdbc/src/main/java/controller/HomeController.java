package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인전에만 진입가능
		HttpSession session = request.getSession();
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null	
		Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
		if(loginMember == null) { // 로그인하지 않았다면
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		// 홈 view
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}
}

