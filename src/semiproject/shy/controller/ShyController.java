package semiproject.shy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShyController
 */
@WebServlet("/shy/*")
public class ShyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShyController() {
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

		case "listenerlist" : listenerList (request, response);
			break;
		case "customerCenter" : customerCenter(request, response); 
			break;
		case "login" : login(request, response); 
			break;
		case "join" : join(request, response); 
			break;
		case "mypage" : mypage(request, response); 
			break;
		case "index" : index(request, response); 
			break;
		case "listMypageReview" : listMypageReview(request, response);
			break;	
		case "counsReview" : counsReview(request, response);
			break;
		case "myPageMain" : myPageMain (request, response);
			break;
		case "mySchedule" : mySchedule (request, response);
			break;
		case "resConfirm" : resConfirm (request, response);
			break;
		case "writeReview" : writeReview (request, response);
			
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
	
	
	
	private void listenerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/board/listenerlist.jsp")
		.forward(request, response);
	}
	
	private void customerCenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/community/customerCenter.jsp")
		.forward(request, response);
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp")
		.forward(request, response);
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/member/join.jsp")
		.forward(request, response);
	}
	
	private void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp")
		.forward(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/index");
	}
	
	private void listMypageReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/review/listMypageReview.jsp")
		.forward(request, response);
	}
	
	private void resConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/resConfirm.jsp")
		.forward(request, response);
	}
	
	private void counsReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/counsReview.jsp")
		.forward(request, response);
	}
	
	private void myPageMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/myPageMain.jsp")
		.forward(request, response);
	}
	
	private void mySchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/mySchedule.jsp")
		.forward(request, response);
	}
	
	private void writeReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/review/writeReview.jsp")
		.forward(request, response);
	}
	
	
}
