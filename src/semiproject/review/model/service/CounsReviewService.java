package semiproject.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.review.model.dao.CounsReviewDao;
import semiproject.review.model.vo.CounsReview;



public class CounsReviewService {
	
	CounsReviewDao counsDao = new CounsReviewDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 후기 리스트
	public ArrayList<CounsReview> selectCounsList(String counsIdx){
		Connection conn = jdt.getConnection();
		ArrayList<CounsReview> counsList = counsDao.selectCounsList(conn);
		jdt.close(conn);
		return counsList;
	}
	
	// 후기등록
	public int insertCouns(CounsReview couns) {
		Connection conn = jdt.getConnection();
		int res = 0;
		
		try {
			res = counsDao.insertCouns(conn, couns);
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
	
	// 후기삭제
	public int deleteCouns(String counsIdx){
		Connection conn = jdt.getConnection();
		
		int res = 0;
		try {
			res = counsDao.counsDelete(conn, counsIdx);
			jdt.commit(conn);
		} catch (DataAccessException e) {
			jdt.rollback(conn);
		}finally {
			jdt.close(conn);
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}