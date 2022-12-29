package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Member;

@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 후 글삭제 가능
		HttpSession session = request.getSession();
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null	
		Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
		if(loginMember == null) { // 로그인하지 않았다면
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo+"<-- RemoveBoardController boardNo");
		String memberId = request.getParameter("memberId");
		System.out.println(memberId+"<-- RemoveBoardController memberId");
		
		//m
		BoardService boardService = new BoardService();
		int row = boardService.removeBoard(boardNo, memberId);
		System.out.println(row + "<--  row");
		if(row == 1){
			System.out.println("<-- 글 삭제 완료");
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		}
		// 뷰가 없다
	}
}