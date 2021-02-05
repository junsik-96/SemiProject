package semiproject.find.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShyController
 */
@WebServlet("/find/*")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindController() {
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
		case "findlis" : findLis(request, response); 
			break;	
		case "search" : search(request, response); 
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
	
	private void findLis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchLis = request.getParameter("search");
		request.setAttribute("searchlist", searchLis);

		 request.getRequestDispatcher("/WEB-INF/view/find/find.jsp")
		 .forward(request, response);
		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchLis = request.getParameter("search");
		request.setAttribute("searchlist", searchLis);

		 request.getRequestDispatcher("/WEB-INF/view/find/find.jsp")
		 .forward(request, response);
		
	}
}
