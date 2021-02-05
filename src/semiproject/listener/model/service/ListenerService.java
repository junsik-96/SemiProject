package semiproject.listener.model.service;

import java.sql.Connection;

import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.dao.ListenerDao;
import semiproject.listener.model.vo.School;

public class ListenerService {

	private ListenerDao listenerDao = new ListenerDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public School selectListBySchool(String school) {
		
		Connection conn = jdt.getConnection();
		School schoolName = null;
		
		try {
			schoolName = listenerDao.selectListBySchool(conn, school);
		}finally {
			jdt.close(conn);
		}
		
		
		return schoolName;
	}
	
	
}
