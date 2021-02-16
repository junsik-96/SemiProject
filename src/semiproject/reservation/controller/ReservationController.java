package semiproject.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import semiproject.common.code.ErrorCode;
import semiproject.common.exception.ToAlertException;

/**
 * Servlet implementation class listenerController
 */
@WebServlet("/reservation/*")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] uriArr = request.getRequestURI().split("/");
		switch(uriArr[uriArr.length-1]) {
		case "view" : gotoView(request,response);
			break;
		case "cancel" : change(request,response);
			break;
		
		default:throw new ToAlertException(ErrorCode.NORES);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/reservation/reservation3.jsp")
		.forward(request, response);
	}
	
	private void change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/reservation/reservation_cancel.jsp")
		.forward(request, response);
	}
	

	
}
