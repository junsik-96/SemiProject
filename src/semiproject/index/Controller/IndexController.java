package semiproject.index.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semiproject.listener.model.vo.Listener;
import semiproject.member.model.vo.Member;
import semiproject.index.model.service.IndexService;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexService indexService = new IndexService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 예약 rank
		
		List<Listener> listenerList1 = indexService.selectByResCnt(1);
		request.setAttribute("rank1", listenerList1);
		List<Listener> listenerList2 = indexService.selectByResCnt(2);
		request.setAttribute("rank2", listenerList2);
		List<Listener> listenerList3 = indexService.selectByResCnt(3);
		request.setAttribute("rank3", listenerList3);
		List<Listener> listenerList4 = indexService.selectByResCnt(4);
		request.setAttribute("rank4", listenerList4);
		
		List<Listener> listenerListLike1 = indexService.selectByLikeCnt(1);
		request.setAttribute("rankLike1", listenerListLike1);
		List<Listener> listenerListLike2 = indexService.selectByLikeCnt(2);
		request.setAttribute("rankLike2", listenerListLike2);
		List<Listener> listenerListLike3 = indexService.selectByLikeCnt(3);
		request.setAttribute("rankLike3", listenerListLike3);
		List<Listener> listenerListLike4 = indexService.selectByLikeCnt(4);
		request.setAttribute("rankLike4", listenerListLike4);
		
		List<Listener> listenerListReg1 = indexService.selectByRegDate(1);
		request.setAttribute("rankReg1", listenerListReg1);
		List<Listener> listenerListReg2 = indexService.selectByRegDate(2);
		request.setAttribute("rankReg2", listenerListReg2);
		List<Listener> listenerListReg3 = indexService.selectByRegDate(3);
		request.setAttribute("rankReg3", listenerListReg3);
		List<Listener> listenerListReg4 = indexService.selectByRegDate(4);
		request.setAttribute("rankReg4", listenerListReg4);
		
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("listType");
		String concern = (String) session.getAttribute("concern");
		
		Listener listener = new Listener();
		
		listener.setListField(concern);
		listener.setType(type);
		
		List<Listener> listComm1 = indexService.selectLisByComm(listener);
		request.setAttribute("comm1", listComm1);
		System.out.println("asd :" + listener);
		
		request.getRequestDispatcher("/WEB-INF/view/index/index.jsp")
		.forward(request, response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
