package semiproject.shy.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.shy.model.dao.CounsMypageDao;
import semiproject.shy.model.vo.CounsReview;
import semiproject.shy.model.vo.Review;

public class CounsMypageService {
	
	CounsMypageDao counsDao = new CounsMypageDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 상담내역
	public ArrayList<CounsReview> selectCounsList(String listId){
		Connection conn = jdt.getConnection();
		
		ArrayList<CounsReview> counsList = null;
		
		try {
			counsList = counsDao.selectCounsList(conn, listId);
		} finally {
			jdt.close(conn);
		}
		
		return counsList;
	}
	
	// 상담후기
	public ArrayList<Review> selectReviewList(String listId){
		Connection conn = jdt.getConnection();
		
		ArrayList<Review> reviewList = null;
		
		try {
			reviewList = counsDao.selectReviewList(conn, listId);
		} finally {
			jdt.close(conn);
		}
		
		return reviewList;
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