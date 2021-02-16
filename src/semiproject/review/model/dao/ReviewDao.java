package semiproject.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.review.model.vo.Review;


public class ReviewDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 상담사 >> 리뷰 리스트
	public ArrayList<Review> selectReviewList(Connection conn, String rvListId){
		
		ArrayList<Review> reviewArr = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			String query = "select * from tb_review where rv_list_id = ?";

			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, rvListId);

			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Review review = new Review();
				review.setRvIdx(rset.getInt("rv_idx"));
				review.setRvListId(rset.getString("rv_list_id"));
				review.setRvResDate(rset.getDate("rv_res_date"));
				review.setReview(rset.getString("review"));
				review.setRvUserId(rset.getString("rv_user_id"));
				review.setRating(rset.getString("rating"));
				reviewArr.add(review);
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return reviewArr;
	}
	
	
	// 후기 등록 메소드
	public int insertReview(Connection conn, Review review) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			String sql = "insert into tb_review(rv_list_id, review, rv_user_id, rating)"
					+ " values (?,?,?,?)";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, review.getRvListId());
			pstm.setString(2, review.getReview());
			pstm.setString(3, review.getRvUserId());
			pstm.setString(4, review.getRating());
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.AUTH01, e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
	// 후기 삭제 메소드
	public int reviewDelete (Connection conn, String rvUserId ) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			String sql = "delete from tb_review where rv_user_id= ? ";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,rvUserId);
			res = pstm.executeUpdate();
			
		}catch (SQLException e) {
			throw new DataAccessException(ErrorCode.AUTH01, e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
	/*
	 * // 리뷰 디테일 public Review selectReviewDetail(Connection conn, String rvListId)
	 * { Review review = null; PreparedStatement pstm = null; ResultSet rs = null;
	 * String sql = "select " +
	 * "rv_idx,rv_list_id,rv_res_date,review,rv_user_id, rating " +
	 * "from tb_review " + "where rv_list_id = ? "; try { pstm =
	 * conn.prepareStatement(sql); pstm.setString(1, rvListId); rs =
	 * pstm.executeQuery();
	 * 
	 * if(rs.next()) { review = new Review(); review.setRvIdx(rs.getInt(1));
	 * review.setRvListId(rs.getString(2)); review.setRvResDate(rs.getDate(3));
	 * review.setReview(rs.getString(4)); review.setRvUserId(rs.getString(5));
	 * review.setRating(rs.getString(6)); } } catch (SQLException e) { throw new
	 * DataAccessException(ErrorCode.AUTH01, e); }finally { jdt.close(rs, pstm); }
	 * 
	 * return review; }
	 */
		
		
		
	
}
