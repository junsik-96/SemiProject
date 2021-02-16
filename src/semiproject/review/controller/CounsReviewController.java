package semiproject.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiproject.review.model.service.CounsReviewService;
import semiproject.review.model.vo.CounsReview;


/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/couns/*")
public class CounsReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounsReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length - 1]) {
		case "listCounsReview" : listCounsReview (request,response);
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
	
	
	
	private void listCounsReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CounsReviewService counsService = new CounsReviewService();
		String counsIdx = request.getParameter("counsIdx");

		List<CounsReview> commandMap = counsService.selectCounsList(counsIdx);
		
		request.setAttribute("counsList", commandMap);
		System.out.println(commandMap);
		request.getRequestDispatcher("/WEB-INF/view/listener-mypage/counsReview.jsp")
		.forward(request, response);
	}
	
	

}


