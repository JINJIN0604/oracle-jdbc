package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;


@WebServlet("/board/boardList")
public class BoardListController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		// 검색 기능
		request.setCharacterEncoding("UTF-8"); // 한글 처리
		String search = request.getParameter("search");
		System.out.println("search : " + search);
		

		
		this.boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoardListByPage(currentPage, rowPerPage, search);
		request.setAttribute("boardList", list);
		request.setAttribute("currentPage", currentPage); // view에서 필요
		request.setAttribute("rowPerPage", rowPerPage); // view에서 필요	
		request.setAttribute("search", search); // view에서 필요	

		
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
	}
}




