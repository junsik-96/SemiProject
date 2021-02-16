package semiproject.payment.model.service;

import java.sql.Connection;
import java.sql.Date;

import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.payment.model.dao.PaymentDao;
import semiproject.payment.model.vo.Payment;

public class PaymentService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	PaymentDao paymentDao = new PaymentDao();
	
	public Listener insertInfo(String ListPro, String ListName, int ListAmt) {
		
		Connection conn = jdt.getConnection();
		
		 Listener listener = null;
		
		try {
			listener = (Listener) paymentDao.insertInfo(conn, ListPro, ListName, ListAmt);
		} finally {
			jdt.close(conn);
		}
		
		return listener;
		
	}
	
	public Payment paying(int pmIdx, Date pmDate, int amount) {
		
		Connection conn = jdt.getConnection();
		
		 Payment payment = null;
		 
		 try {
			 payment = paymentDao.paying(conn, pmIdx, pmDate, amount);
			} finally {
				jdt.close(conn);
			}
			
		 
		 return payment;
		
	}
	
}