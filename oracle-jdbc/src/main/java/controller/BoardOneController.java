package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

@WebServlet("/board/boardOne")
public class BoardOneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * view메뉴구성
		 * 글수정(로그인멤버 == 글쓴이)
		 * 글삭제(로그인멤버 == 글쓴이)
		 * 
		 * 
		 */
		
		
		
		
		request.setCharacterEncoding("UTF-8"); // 인코딩
		
		if(request.getParameter("boardNo")==null) { // 파라메타 값 유효성 검사
			response.sendRedirect(request.getContextPath()+"/BoardListController");
			return;
		}
		
		// Form에서 가져오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo + "<-- BoardOneController boardNo");

		BoardService boardService = new BoardService();
		Board b = boardService.boardOne(boardNo);
		
		request.setAttribute("b", b); // view 페이지와 공유할 모델데이터 저장
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardOne.jsp").forward(request, response);
		 
	
	}

}
