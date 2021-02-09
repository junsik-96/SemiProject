package semiproject.listener.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.dao.ListenerDao;
import semiproject.listener.model.vo.School;
import semiproject.listener.model.vo.Class;

public class ListenerService {

	private ListenerDao listenerDao = new ListenerDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public List<School> selectListBySchool(String school) {
		
		Connection conn = jdt.getConnection();
		List<School> schoolList = null;
		
		try {
			schoolList = listenerDao.selectListBySchool(conn, school);
		}finally {
			jdt.close(conn);
		}	
		return schoolList;
	}
	
	public List<Class> selectListByClass(String class1) {
		
		Connection conn = jdt.getConnection();
		List<Class> classList = null;
		
		try {
			classList = listenerDao.selectListByClass(conn, class1);
		}finally {
			jdt.close(conn);
		}	
		return classList;
	}
	
	
}
