package semiproject.payment.model.service;

import semiproject.common.template.JDBCTemplate;
import semiproject.payment.model.dao.PaymentDao;

public class PaymentService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	PaymentDao paymentDao = new PaymentDao();
	
}
