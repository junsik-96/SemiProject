package semiproject.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.member.model.dao.MypageDao;


public class MypageService {
	
	MypageDao mypageDao = new MypageDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public ArrayList<Listener> selectListener(String userId) {
		Connection conn = jdt.getConnection();
		
		ArrayList<Listener> listIdArr = null;
		
		try {
			listIdArr = mypageDao.selectListener(conn, userId);
		} finally {
			jdt.close(conn);
		}
		
		return listIdArr;
	}
	
	public Listener selectListenerById(String listId) {
		Connection conn = jdt.getConnection();
		
		Listener listener = null;
		
		try {
			listener = mypageDao.selectListenerById(conn, listId);
		} finally {
			jdt.close(conn);
		}
		
		return listener;
	}

}
