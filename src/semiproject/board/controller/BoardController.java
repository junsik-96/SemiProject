package semiproject.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import semiproject.board.model.service.BoardService;
import semiproject.board.model.vo.Board;
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
		case "board" : boardView(request,response);
			break;
		case "boardForm" : boardForm(request,response);
			break;
		case "boardDetail" : boardDetail(request, response); 
			break;
		case "upload" : uploadBoard(request,response);
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
	
	private void boardView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Board> bList = null;
		bList = boardService.selectBoardInfo();
		System.out.println(bList);
		request.setAttribute("bInfo", bList);
		 
		request.getRequestDispatcher("/WEB-INF/view/board/boardView.jsp")
		.forward(request, response);
	}
	
	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String a = request.getParameter("bdIdx"); int bdIdx = Integer.parseInt(a);
		 * Map<String,Object> commandMap = boardService.selectBoardDetail(bdIdx);
		 * request.setAttribute("data", commandMap);
		 */
		String a = request.getParameter("idx"); 
		int bdIdx = Integer.parseInt(a);
		Board board = boardService.selectByIdx(bdIdx);
		request.setAttribute("bDetail", board); 
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardDetail.jsp")
		.forward(request, response);
	}
	
	private void boardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/board/boardForm.jsp")
		.forward(request, response);
	}
	
	private void uploadBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  HttpSession session = request.getSession(); 
		  Member member = (Member) session.getAttribute("user");
		  System.out.println(member);
		boardService.insertBoard(member.getUserId(), request);
		
		 request.setAttribute("alertMsg", "게시글 등록이 정상적으로 완료되었습니다.");
		 request.setAttribute("url", "/board");

		List<Board> bList = null;
		bList = boardService.selectBoardInfo();
		System.out.println(bList);
		request.setAttribute("bInfo", bList);
		 
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardView.jsp")
		.forward(request, response);
	}
	
	
	


}
