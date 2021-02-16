package semiproject.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import semiproject.listener.model.vo.Listener;
import semiproject.member.model.service.MemberService;
import semiproject.member.model.service.MypageService;
import semiproject.member.model.vo.Cart;
import semiproject.member.model.vo.Likey;
import semiproject.member.model.vo.Member;
import semiproject.payment.model.vo.Payment;
import semiproject.reservation.model.vo.Reservation;

/**
 * Servlet implementation class memberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberService();
	MypageService mypageService = new MypageService();
       
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
			case "KakaoLogin" : kakaoLogin(request,response); //카카오 로그인
				break;
			case "loginimpl" : loginImpl(request, response);
				break;
			case "join" : join(request,response); //회원가입
				break;
			case "idcheck" : confirmId(request,response);
				break;
			case "mailauth" : authenticateEmail(request,response);
				break;
			case "joinimpl" : joinImpl(request, response);
				break;
			case "logout" : logout(request,response);
				break;
			case "likey" : likey(request,response);
				break;
			case "mypage" : myPage(request,response); //마이페이지
				break;
			case "user_modify" : userModify(request,response); //내정보수정
				break;
			case "modifyimpl" : userModifyImpl(request,response);
				break;
			case "hold" : holdInfo(request,response); //찜목록
				break;
			case "holdAction" : holdAction(request,response);
				break;
			case "holdDelete" : holdDelete(request,response);
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
	
	private void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String userId = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        
        String[] names = name.split("\"");
        String[] emails = email.split("\"");
        String[] births = birth.split("\"");
        
        //회원이 있는지 검사, 없으면 회원가입부터 진행 후 로그인
        Member member = memberService.selectMemberById(userId);
        
        if(member == null) {
            //회원가입이 필요
            Member memberInput = new Member();
            memberInput.setUserId(userId);
            memberInput.setName(names[1]);
            memberInput.setUserType("일반회원");
            memberInput.setEmail(emails[1]);
            memberInput.setBirth(births[1]);
            
            //회원가입 실행
            int res = memberService.insertMember(memberInput);
            
            if(res > 0) {
                //로그인
                Member memberLogin = memberService.kmemberAuthenticate(userId);
                
                session = request.getSession();
                session.setAttribute("user", memberLogin);
                response.getWriter().append("/");
            }else {
                System.out.println("카카오 회원가입 실패");
            }
            
        }else {
            //있는 회원
            session.setAttribute("user", member);
            response.getWriter().append("/");
        }
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
		Listener listener = memberService.listIsTrueCheck(userId);
		
		if(member.getUserType().equals("상담사")) {
			request.getSession().setAttribute("listTrue", listener.getListIsTrue());	
		}
		
		if(member != null) {
			//session에 회원 정보를 저장
			request.getSession().setAttribute("user", member);
			request.getSession().setAttribute("listId", member.getUserId());
			request.getSession().setAttribute("userType", member.getUserType());
			request.getSession().setAttribute("listType", member.getListType());
			request.getSession().setAttribute("concern", member.getConcern());
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

	private void confirmId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		Member member = memberService.selectMemberById(userId);
		
		//아이디가 있다.
		if(member != null) {
			//응답 body에 fail 작성
			response.getWriter().print("fail");
		//아이디가 없다.
		}else {
			//응답 body에 success 작성
			response.getWriter().print("success");
		}
	}
	
	private void authenticateEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String userType = request.getParameter("userType");
		String birth = request.getParameter("birth");
		String concern = request.getParameter("concern");
		String listType = request.getParameter("listType");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		member.setEmail(email);
		member.setName(name);
		member.setTel(tel);
		member.setUserType(userType);
		member.setBirth(birth);
		member.setConcern(concern);
		member.setListType(listType);
		
		memberService.authenticateEmail(member);
		
		request.getSession().setAttribute("persistUser", member);
		
		request.setAttribute("msg", "회원가입 완료를 위한 이메일이 발송되었습니다.");
		request.setAttribute("url", "/index");
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
	}
	
	private void joinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("persistUser");
		
		memberService.insertMember(member);
		memberService.insertListener(member);
		
		//회원가입 정보를 삭제
		request.getSession().removeAttribute("persistUser");
		
		request.setAttribute("msg", "회원가입을 축하드립니다.");
		request.setAttribute("url", "/member/login");
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("userType");
		response.sendRedirect("/index");
	}
	
	private void likey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("user");
		
		Likey likey = new Likey();
		
		likey.setUserId(member.getUserId());
		likey.setListId(request.getParameter("listId"));
		
		mypageService.likey(likey);
		
			mypageService.addLikey(request.getParameter("listId"));
		
		response.sendRedirect("/listener/all");
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
	
	private void userModifyImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Member member = (Member) request.getSession().getAttribute("user");
		String name = request.getParameter("name");
		String concern = request.getParameter("concern");
		String listType = request.getParameter("listType");
		String tel = request.getParameter("tel");
		
		member.setName(name);
		member.setConcern(concern);
		member.setListType(listType);
		member.setTel(tel);
		
		memberService.updateMember(member);
		
		request.setAttribute("msg", "회원 정보가 수정되었습니다.");
		request.setAttribute("url", "/member/mypage");
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
	}
	
	private void holdInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("user");
		
		String userId = member.getUserId();
		ArrayList<Listener> listIdArr = null;
		ArrayList<Listener> listArr = new ArrayList<>();
		
		listIdArr = mypageService.selectListener(userId);
		
		if(listIdArr.size()!=0) {
			for(int i = 0; i < listIdArr.size(); i++) {
				listArr.add(mypageService.selectListenerById(listIdArr.get(i).getListId()));
			}
		}

		request.setAttribute("listArr", listArr);
		
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/holdInfo.jsp")
		.forward(request, response);
	}
	
	private void holdAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("user");
		
		Cart cart = new Cart();
		
		cart.setUserId(member.getUserId());
		cart.setListId(request.getParameter("listId"));
		
		mypageService.insertHold(cart);
		
		response.sendRedirect("/member/hold");
	}
	
	private void holdDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("user");
		
		Cart cart = new Cart();
		
		cart.setUserId(member.getUserId());
		cart.setListId(request.getParameter("listId"));
		
		mypageService.DeleteHold(cart);
		
		response.sendRedirect("/member/hold");
	}
	
	private void reservationInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("user");
		
		String userId = member.getUserId();
		
		ArrayList<Reservation> reservationArr = mypageService.selectReservationById(userId);

		request.setAttribute("reservationArr", reservationArr);
		
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/reservationInfo.jsp")
		.forward(request, response);
	}
	
	private void paymentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("user");
		
		String userId = member.getUserId();
		
		ArrayList<Reservation> reservationArr = mypageService.selectReservationById(userId);
		ArrayList<Payment> paymentArr = new ArrayList<>();
		
		if(reservationArr.size()!=0) {
			for(int i = 0; i < reservationArr.size(); i++) {
				for(int j = 0; j < mypageService.selectPayment(reservationArr.get(i).getResIdx()).size(); j++) {
					paymentArr.add(mypageService.selectPayment(reservationArr.get(i).getResIdx()).get(j));
				}
			}
		}

		request.setAttribute("paymentArr", paymentArr);
		
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/paymentInfo.jsp")
		.forward(request, response);
	}
	
	private void myBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/myBoard.jsp")
		.forward(request, response);
	}
	
	
}
