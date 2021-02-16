package semiproject.shy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.shy.model.vo.CounsReview;
import semiproject.shy.model.vo.Review;


public class CounsMypageDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 상담일지 리스트
	public ArrayList<CounsReview> selectCounsList(Connection conn, String listId){
		
		ArrayList<CounsReview> counsList = new ArrayList<CounsReview>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from tb_couns_review where couns_list_id = ?";
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, listId);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				CounsReview couns = new CounsReview();
				couns.setCounsIdx(rset.getString("couns_idx"));
				couns.setCounsListId(rset.getString("couns_list_id"));
				couns.setCounsDate(rset.getDate("couns_date"));
				couns.setCounsReview(rset.getString("couns_review"));
				couns.setCounsUserId(rset.getString("couns_user_id"));
				counsList.add(couns);
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return counsList;
	}
	
	// 상담후기
	public ArrayList<Review> selectReviewList(Connection conn, String listId){
		
		ArrayList<Review> reviewList = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from tb_review where rv_list_id = ?";
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, listId);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Review review = new Review();
				review.setRvIdx(rset.getInt("rv_idx"));
				review.setRvListId(rset.getString("rv_list_id"));
				review.setRvResDate(rset.getDate("rv_res_date"));
				review.setReview(rset.getString("review"));
				review.setRvUserId(rset.getString("rv_user_id"));
				review.setRating(rset.getString("rating"));
				reviewList.add(review);
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return reviewList;
	}
	
	
	// 후기 등록 메소드
	public int insertCouns(Connection conn, CounsReview couns) {
		int res = 0;
		PreparedStatement pstm = null;
		
		try {
			String sql = "insert into tb_couns_review(couns_list_id, couns_review, couns_user_id, couns_date)"
					+ " values (?,?,?,?)";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, couns.getCounsListId());
			pstm.setString(2, couns.getCounsReview());
			pstm.setString(3, couns.getCounsUserId());
			pstm.setDate(4, couns.getCounsDate());
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.AUTH01, e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
	
	
	// 후기 삭제 메소드
	public int counsDelete (Connection conn, String counsIdx ) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			String sql = "delete from tb_couns_review where couns_idx= ? ";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,counsIdx);
			res = pstm.executeUpdate();
			
		}catch (SQLException e) {
			throw new DataAccessException(ErrorCode.AUTH01, e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
		
		
		
		
	
}
