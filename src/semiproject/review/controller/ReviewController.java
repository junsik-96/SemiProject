package semiproject.review.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiproject.review.model.service.ReviewService;
import semiproject.review.model.vo.Review;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review/*")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length - 1]) {
		case "listMypageReview" : listMypageReview (request,response);
			break;
		case "upload" : uploadReview (request, response);
			break;
		case "reviewList" : reviewList (request, response);
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
	
	private void listMypageReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/review/listMypageReview.jsp")
		.forward(request, response);
	}
	
	private void uploadReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/review/writeReview.jsp")
		.forward(request, response);
	}
	
	
	private void reviewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/review/listMypageReview.jsp")
		.forward(request, response);
		
	}

}
