package semiproject.payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.ToAlertException;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/payment/*")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
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
		case "paying" : paynow(request,response);
		case "paid" : deal(request,response);
		default:throw new ToAlertException(ErrorCode.PAY_404);
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
		request.getRequestDispatcher("/WEB-INF/view/payment/payment.jsp")
		.forward(request, response);
	}
	
	private void paynow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/payment/paying.jsp")
		.forward(request, response);
	}
	
	private void deal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/payment/paid.jsp")
		.forward(request, response);
	}
}