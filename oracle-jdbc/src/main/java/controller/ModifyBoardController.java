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

@WebServlet("/board/modifyBoard")
public class ModifyBoardController extends HttpServlet {

	// 글 수정 폼
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
		request.setCharacterEncoding("UTF-8"); //인코딩
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardService boardService = new BoardService();
		Board b = boardService.boardOne(boardNo);
		
		// view와 공유할 모델데이터 설정
		request.setAttribute("b", b); 	
		request.getRequestDispatcher("/WEB-INF/view/board/modifyBoard.jsp").forward(request, response);
	}

	// 글 수정 액션
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
		request.setCharacterEncoding("UTF-8"); // 인코딩
		
		// form 에서 값 받기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String memberId = request.getParameter("memberId");
		System.out.println(boardNo+"<-- boardTitle");
		System.out.println(boardTitle+"<-- boardTitle");
		System.out.println(boardContent+"<-- boardContent");
		System.out.println(memberId+"<-- memberId");
		
		Board board = new Board(); //vo
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		System.out.println(board+"<-- board");
		
		BoardService boardService = new BoardService();
		int row = boardService.modifyBoard(board, boardContent);
		if(row == 1) {
			System.out.println(row+"<-- row");
		}
		// 뷰가 없다	
		response.sendRedirect(request.getContextPath()+"/board/boardList?boardNo="+boardNo);
	}
}
