package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

/**
 * Servlet implementation class AddBoardController
 */
@WebServlet("/board/addBoard")
public class AddBoardController extends HttpServlet {
	private BoardService boardService;
	
	// 글쓰기 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인전에만 진입가능
		HttpSession session = request.getSession();
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null	
		Member loginMember = (Member)session.getAttribute("loginMember"); //로그인전이면 이 값은 null
		if(loginMember == null) { // 로그인하지 않았다면
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/board/addBoard.jsp").forward(request, response);
	}

	// 글쓰기 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 인코딩
		
		// form 에서 값 받기
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String memberId = request.getParameter("memberId");
		System.out.println(boardTitle+"<-- AddBoardController boardTitle");
		System.out.println(boardContent+"<-- AddBoardController boardContent");
		System.out.println(memberId+"<-- AddBoardController memberId");
		
		Board board = new Board(); //vo
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		System.out.println(board+"<-- AddBoardController board");
		
		this.boardService = new BoardService();
		int row = boardService.addBoard(board);
		if(row == 1) {
			System.out.println(row+"<-- AddBoardController row");
		}
		// 뷰가 없다
		response.sendRedirect(request.getContextPath()+"/board/boardList");

	}

}
