package semiproject.index.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;

import semiproject.index.model.dao.IndexDao;
import semiproject.listener.model.vo.Listener;

public class IndexService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	IndexDao indexDao = new IndexDao();
	
	public List<Listener> selectByResCnt(int ranking) {
		
		List<Listener> listenerList = new ArrayList<Listener>();
		Connection conn = jdt.getConnection();
		
		try {
			Listener listener = indexDao.selectByResCnt(conn,ranking);
			listenerList.add(listener);
		}finally {
			jdt.close(conn);
		}
		 
		
		return listenerList;
	}
	
	public List<Listener> selectByLikeCnt(int ranking) {
		
		List<Listener> listenerList = new ArrayList<Listener>();
		Connection conn = jdt.getConnection();
		
		try {
			Listener listener = indexDao.selectByLikeCnt(conn, ranking);
			listenerList.add(listener);
		}finally {
			jdt.close(conn);
		}
		 
		
		return listenerList;
	}
	
	public List<Listener> selectByRegDate(int ranking) {
		
		List<Listener> listenerList = new ArrayList<Listener>();
		Connection conn = jdt.getConnection();
		
		try {
			Listener listener = indexDao.selectByRegDate(conn, ranking);
			listenerList.add(listener);
		}finally {
			jdt.close(conn);
		}
		 
		
		return listenerList;
	}
	
}
