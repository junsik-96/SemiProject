package semiproject.listener.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semiproject.listener.model.vo.Listener;
import semiproject.listener.model.service.ListenerService;
import semiproject.listener.model.vo.Class;
import semiproject.listener.model.vo.FindListener;
import semiproject.listener.model.vo.School;
import semiproject.member.model.vo.Member;

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
		case "listenerjoinimpl" : listenerJoinImpl(request,response);
			break;
		case "findschool" : findSchool(request,response);
			break;
		case "findclass" : findClass(request,response);
			break;
		case "all" : all(request,response);
			break;
		case "search" : search(request,response);
			break;
		case "findlist" : findCheck(request,response);
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
	
	private void listenerJoinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member member = new Member();
		
		String listGen = request.getParameter("list_gen");
		String listType = request.getParameter("list_type");
		String listSchool = request.getParameter("choose_school");
		String listClass = request.getParameter("choose_class");
		String[] listLicense = request.getParameterValues("list_licen");
		String listField = request.getParameter("lis_field");
		String[] listJob = request.getParameterValues("list_job");
		String listId = (String) session.getAttribute("listId");

	
		Listener listener = new Listener();
		
		listener.setListGen(listGen);
		listener.setType(listType);
		listener.setListSchool(listSchool);
		listener.setListClass(listClass);
		listener.setListLicense(listLicense);
		listener.setListField(listField);
		listener.setListJob(listJob);
		listener.setListId(listId);
	
		System.out.println(listener.toString());
		System.out.println(Arrays.toString(listLicense));
		
		listenerService.updateListener(listener);
		request.setAttribute("url", "/index");
		
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
	}
	
	private void findSchool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String schoolName = request.getParameter("school");
		List<School> schoolList = null;
		schoolList = listenerService.selectListBySchool(schoolName);
		System.out.println(schoolList);
		request.setAttribute("uniList", schoolList);
		request.getRequestDispatcher("/WEB-INF/view/listener/findSchool.jsp")
		.forward(request, response);
	}
	
	private void findClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String className = request.getParameter("class");
		List<Class> classList = null;
		classList = listenerService.selectListByClass(className);
		request.setAttribute("claList", classList);
		
		request.getRequestDispatcher("/WEB-INF/view/listener/findClass.jsp")
		.forward(request, response);
	}
	
	private void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Listener> resultAll = listenerService.selectListenerAll();
		request.setAttribute("all", resultAll); 

		request.getRequestDispatcher("/WEB-INF/view/find/find.jsp")
		.forward(request, response);
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String listWho = request.getParameter("searchlis");
		
		List<Listener> resultLis = listenerService.selectListenerBySearch(listWho);
		request.setAttribute("result", resultLis);
		
		System.out.println(resultLis.toString());

		
		request.getRequestDispatcher("/WEB-INF/view/find/findResult.jsp")
		.forward(request, response);
	}
	
	private void findCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] lisType = request.getParameterValues("job");
		String[] lisGen = request.getParameterValues("gender");
		String[] lisField = request.getParameterValues("sector");
		
		String[] age = request.getParameterValues("age");
		String[] price = request.getParameterValues("price");
		int[] lisAge = new int[age.length];
		int[] lisPrice = new int[price.length];
		
		for(int i=0; i<age.length; i++) {
			lisAge[i] = Integer.parseInt(age[i]); 
		}
		
		for(int i=0; i<price.length; i++) {
			lisPrice[i] = Integer.parseInt(price[i]); 
		}
		 
		FindListener findListener = new FindListener();
		findListener.setListType(lisType);
		findListener.setListGen(lisGen);
		findListener.setListField(lisField); 
		findListener.setListAge(lisAge);
		findListener.setListPrice(lisPrice);
		
		
		
		System.out.println(Arrays.toString(lisType));
		
		List<Listener> CheckLis = listenerService.selectListenerByCheck(findListener);
		request.setAttribute("checkLis", CheckLis);  
		System.out.println(CheckLis); 
		request.getRequestDispatcher("/WEB-INF/view/find/findResult.jsp")
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
