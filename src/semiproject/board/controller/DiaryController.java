package semiproject.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import semiproject.board.model.service.DiaryService;
import semiproject.member.model.vo.Member;

/**
 * Servlet implementation class DiaryController
 */
@WebServlet("/diary/*")
public class DiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiaryService diaryService = new DiaryService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryController() {
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
		case "diary" : diary(request, response); 
			break;
		case "diaryForm" : diaryForm(request, response);
			break;
		case "diaryDetail" : diaryDetail(request, response); 
			break;
		case "upload" : uploadDiary(request,response);
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
	
	private void diary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/diary/diary.jsp")
		.forward(request, response);
	}
	
	private void diaryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/diary/diaryDetail.jsp")
		.forward(request, response);
	}
	
	private void diaryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/diary/diaryForm.jsp")
		.forward(request, response);
	}
	
	private void uploadDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("user");
		System.out.println(member); 
		diaryService.insertDiary(member.getUserId(), request);
		
		request.setAttribute("alertMsg", "게시글 등록이 정상적으로 완료되었습니다.");
		request.setAttribute("url", "/diary");
		request.getRequestDispatcher("/WEB-INF/view/diary/diaryView.jsp")
		.forward(request, response);
	}

}
