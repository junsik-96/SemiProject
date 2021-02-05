package semiproject.listener.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiproject.listener.model.service.ListenerService;
import semiproject.listener.model.vo.School;

/**
 * Servlet implementation class ListenerController
 */
@WebServlet("/listener/*")
public class ListenerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ListenerService listenerService = new ListenerService();  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length - 1]) {
		case "before" : before(request,response);
			break;
		case "listenerjoin" : listenerJoin(request,response);
			break;
		case "findschool" : findSchool(request,response);
			break;
		case "couns" : couns(request,response);
			break;
		case "mypage" : mypage(request,response);
			break;
		case "schedule" : schedule(request,response);
			break;
		case "confirm" : confirm(request,response);
			break;
		case "review" : review(request,response);
			break;
		default : response.setStatus(404);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void before(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener/joinBeforeLis.jsp")
		.forward(request, response);
	}
	
	private void listenerJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener/listenerJoin.jsp")
		.forward(request, response);
	}
	
	private void findSchool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String schoolName = request.getParameter("school");
		School school = listenerService.selectListBySchool(schoolName);
		System.out.println(school);
		
		request.getRequestDispatcher("/WEB-INF/view/listener/findSchool.jsp")
		.forward(request, response);
	}
	
	private void couns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/counsReview.jsp")
		.forward(request, response);
	}
	
	private void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/myPageMain.jsp")
		.forward(request, response);
	}
	
	private void schedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/mySchedule.jsp")
		.forward(request, response);
	}
	
	private void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/resConfirm.jsp")
		.forward(request, response);
	}
	
	private void review(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/reviews.jsp")
		.forward(request, response);
	}

}
