package semiproject.listener.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.find.model.vo.Listener;
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
	
	public int updateListener(Listener listener) {
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			//Dao의 메서드로 생성한 Connection을 주입
			 res = listenerDao.updateListener(conn, listener);
			//Dao에서 아무 문제없이 실행이 끝난다면 commit;
			jdt.commit(conn);
		}catch(DataAccessException e) {
			//Dao에서 SQLException이 발생할 경우 rollback처리
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	
}
