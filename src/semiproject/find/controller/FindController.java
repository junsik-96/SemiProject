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
<<<<<<< HEAD
		case "find" : find(request, response); 
=======
		case "findlis" : findLis(request, response); 
>>>>>>> e47105436687321abef1d4fb2b15b7c955216e14
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
	
<<<<<<< HEAD
	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/find/find.jsp")
		.forward(request, response);
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
=======
	private void findLis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>>>>>>> e47105436687321abef1d4fb2b15b7c955216e14
		
		String searchLis = request.getParameter("search");
		request.setAttribute("searchlist", searchLis);

<<<<<<< HEAD
		request.getRequestDispatcher("/WEB-INF/view/find/find.jsp") 
		.forward(request,response); 
		 

		
	
=======
		 request.getRequestDispatcher("/WEB-INF/view/find/find.jsp")
		 .forward(request, response);
		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchLis = request.getParameter("search");
		request.setAttribute("searchlist", searchLis);

		 request.getRequestDispatcher("/WEB-INF/view/find/find.jsp")
		 .forward(request, response);
		
>>>>>>> e47105436687321abef1d4fb2b15b7c955216e14
	}

}
