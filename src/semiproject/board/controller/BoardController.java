package semiproject.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semiproject.board.model.service.BoardService;
import semiproject.member.model.vo.Member;



/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] uriArr = request.getRequestURI().split("/");
		switch(uriArr[uriArr.length-1]) {
		case "gotoView" : gotoView(request,response);
			break;
		case "gotoForm" : gotoForm(request,response);
			break;
		case "upload" : uploadBoard(request,response);
			break;
		case "detail" : boardDetail(request,response);
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void gotoView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/board/boardView.jsp")
		.forward(request, response);
	}
	
	private void gotoForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/board/boardForm.jsp")
		.forward(request, response);
	}
	
	private void uploadBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("user");
		boardService.insertBoard(member.getUserId(), request);
		
		request.setAttribute("alertMsg", "게시글 등록이 완료되었습니다.");
		request.setAttribute("url", "/board");
		request.getRequestDispatcher("/WEB-INF/view/board/boardView.jsp")
		.forward(request, response);
		
	}
	
	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bdIdx = request.getParameter("bdIdx");
		Map<String,Object> commandMap = boardService.selectBoardDetail(bdIdx);
		request.setAttribute("data", commandMap);
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardView.jsp")
		.forward(request, response);
	}
	


}
