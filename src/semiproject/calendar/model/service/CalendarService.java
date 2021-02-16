package semiproject.calendar.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.calendar.model.dao.CalendarDao;
import semiproject.calendar.model.vo.Calendar;
import semiproject.common.template.JDBCTemplate;

public class CalendarService {

		JDBCTemplate jdt = JDBCTemplate.getInstance();
		CalendarDao calendarDao = new CalendarDao();
		
		// 상담사 >> 예약
		public ArrayList<Calendar> selectResDetail(String resListId){
			Connection conn = jdt.getConnection();
			
			ArrayList<Calendar> calendarArr = null;
			
			try {
				calendarArr = calendarDao.selectResDetail(conn, resListId);
			} finally {
				jdt.close(conn);
			}
			
			return calendarArr;
		}
		
		

	
	
}
