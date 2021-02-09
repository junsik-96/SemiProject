package semiproject.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.review.model.dao.ReviewDao;
import semiproject.review.model.vo.Review;


public class ReviewService {
	
	ReviewDao reviewDao = new ReviewDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 후기 리스트
	public ArrayList<Review> selectReviewList(){
		Connection conn = jdt.getConnection();
		ArrayList<Review> reviewList = reviewDao.selectReviewList(conn);
		jdt.close(conn);
		return reviewList;
	}
	
	// 후기등록
	public int insertReview(Review review) {
		Connection conn = jdt.getConnection();
		int res = 0;
		
		try {
			res = reviewDao.insertReview(conn, review);
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
	public int deleteReview(String rvUserId){
		Connection conn = jdt.getConnection();
		
		int res = 0;
		try {
			res = reviewDao.reviewDelete(conn, rvUserId);
			jdt.commit(conn);
		} catch (DataAccessException e) {
			jdt.rollback(conn);
		}finally {
			jdt.close(conn);
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}