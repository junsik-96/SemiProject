package semiproject.calendar.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.calendar.model.dao.CalendarDao;
import semiproject.calendar.model.vo.Calendar;
import semiproject.common.template.JDBCTemplate;
import semiproject.reservation.model.vo.Reservation;

public class CalendarService {

		JDBCTemplate jdt = JDBCTemplate.getInstance();
		CalendarDao calendarDao = new CalendarDao();
		
		// 상담사 >> 예약
		public ArrayList<Calendar> selectResDetail(String listId){
			Connection conn = jdt.getConnection();
			
			ArrayList<Calendar> resList = null;
			
			try {
				resList = calendarDao.selectResDetail(conn, listId);
			} finally {
				jdt.close(conn);
			}
			
			return resList;
		}
		
		

	
	
}
