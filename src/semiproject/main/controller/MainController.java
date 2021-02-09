/*
 * package semiproject.main.controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import semiproject.find.model.vo.Listener; import
 * semiproject.main.model.service.MainService;
 * 
 *//**
	 * Servlet implementation class MainController
	 */
/*
 * @WebServlet("/index111") public class MainController extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 * private MainService mainService = new MainService();
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public MainController() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * List<Listener> listenerList = mainService.selectByResCnt();
 * request.setAttribute("rank", listenerList);
 * request.getRequestDispatcher("/WEB-INF/view/index/index.jsp")
 * .forward(request, response);
 * 
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */