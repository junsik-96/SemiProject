package semiproject.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semiproject.member.model.service.MemberService;
import semiproject.member.model.vo.Member;

/**
 * Servlet implementation class memberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length - 1]) {
			case "login" : login(request,response); //로그인
				break;
			case "loginImpl" : loginImpl(request, response);
				break;
			case "join" : join(request,response); //회원가입
				break;
			case "mypage" : myPage(request,response); //마이페이지
				break;
			case "user_modify" : userModify(request,response); //내정보수정
				break;
			case "hold" : holdInfo(request,response); //찜목록
				break;
			case "reservation" : reservationInfo(request,response); //예약내역
				break;
			case "payment" : paymentInfo(request,response); //결제내역
				break;
			case "myboard" : myBoard(request,response);
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
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp")
		.forward(request, response);
	}
	
	private void loginImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jsonData = request.getParameter("data");
		
		System.out.println("json형식으로 넘어온 데이터 : " + jsonData);
		
		Gson gson = new Gson();
		Map<String,Object> jsonMap = gson.fromJson(jsonData, Map.class);
		
		String userId = (String) jsonMap.get("id");
		String password = (String) jsonMap.get("pw");
		
		Member member = memberService.memberAuthenticate(userId, password);
		
		if(member != null) {
			//session에 회원 정보를 저장
			request.getSession().setAttribute("user", member);
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
		
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/member/join.jsp")
		.forward(request, response);
	}
	
	private void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/mypage.jsp")
		.forward(request, response);
	}
	
	private void userModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/user_modify.jsp")
		.forward(request, response);
	}
	
	private void holdInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/holdInfo.jsp")
		.forward(request, response);
	}
	
	private void reservationInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/reservationInfo.jsp")
		.forward(request, response);
	}
	
	private void paymentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/paymentInfo.jsp")
		.forward(request, response);
	}
	
	private void myBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/myBoard.jsp")
		.forward(request, response);
	}

}
