package semiproject.calendar.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semiproject.calendar.model.dao.CalendarDao;
import semiproject.calendar.model.vo.Calendar;
import semiproject.common.template.JDBCTemplate;

public class CalendarService {

		JDBCTemplate jdt = JDBCTemplate.getInstance();
		CalendarDao calendarDao = new CalendarDao();

		// 예약 리스트
		public ArrayList<Calendar> selectResList(){
			Connection conn = jdt.getConnection();
			ArrayList<Calendar> resList = calendarDao.selectResList(conn);
			
			jdt.close(conn);
			return resList;
		}
		
		// 예약회원, 상담사 일치 >> 예약
		public List<Calendar> selectResDetail(String resListId){
			Connection conn = jdt.getConnection();
			List<Calendar> resList = calendarDao.selectResDetail(conn, resListId);
			
			jdt.close(conn);
			return resList;
		}

		
		
		
		
		
		
		
		
		

	
	
}
