package semiproject.calendar.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semiproject.calendar.model.vo.Calendar;
import semiproject.calendar.model.service.CalendarService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/calendar/*")
public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CalendarService calendarService = new CalendarService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarController() {
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
		case "ResCal" : ResCal(request,response);
			break;
		default: response.setStatus(404);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void ResCal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Calendar calendar = (Calendar)session.getAttribute("user");
		
		String resListId = calendar.getResListId();
		
		ArrayList<Calendar> calendarArr = calendarService.selectResDetail(resListId);
		
		request.setAttribute("calendarArr", calendarArr);
		
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/mySchedule.jsp")
		.forward(request, response);
	}
	


}
