package semiproject.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiproject.board.model.service.NoticeService;
import semiproject.board.model.vo.Board;
import semiproject.board.model.vo.Notice;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService = new NoticeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
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
		case "notice" : notice(request, response); 
			break;
		case "noticeDetail" : noticeDetail(request, response); 
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
	
	private void notice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Notice> nList = null;
		nList = noticeService.selectNoticeList();
		/* System.out.println(nList); */
		request.setAttribute("nInfo", nList);
		
		request.getRequestDispatcher("/WEB-INF/view/notice/notice.jsp")
		.forward(request, response);
	}
	
	private void noticeDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a = request.getParameter("idx"); 
		int bdIdx = Integer.parseInt(a);
		Notice notice = noticeService.selectByIdx(bdIdx);
		request.setAttribute("nDetail", notice); 

		request.getRequestDispatcher("/WEB-INF/view/notice/noticeDetail.jsp")
		.forward(request, response);
	}


}
