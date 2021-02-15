package semiproject.reservation.model.service;

import semiproject.common.template.JDBCTemplate;
import semiproject.reservation.model.dao.ReservationDao;

public class ReservationService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	ReservationDao reservationDao = new ReservationDao();
	
	
}
