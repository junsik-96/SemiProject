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
	private PreparedStatement pstm;
	private ResultSet rs;
	private Connection conn;
	
	// 현재시간 가져오기
	public String getDate() {
		String SQL = "SELECT NOW()";
		 try{
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		
		}
	
		// 다음 글 가져오기
		public int getNext() {
			String SQL = "SELECT rv_idx from tb_review order by rv_idx desc";
			 try{
				pstm = conn.prepareStatement(SQL);
				rs = pstm.executeQuery();
				if (rs.next()) {
					return rs.getInt(1) + 1;
				}
				return 1; // 첫번째 게시물인 경우
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -1; // db오류	
		}
	
	
	// 댓글 등록	
	public int insertReview(Connection conn, Review review) {
		
		int res = 0;
		String SQL = "insert into tb_review values (?,?,?,?,?,?)";
		 try{
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, getNext());
			pstm.setString(2, review.getRvListId());
			pstm.setDate(3, review.getRvResDate());
			pstm.setString(4, review.getReview());
			pstm.setString(5, review.getRvUserId());
			pstm.setString(6, review.getRating());
			
			res = pstm.executeUpdate();
			
		}catch (Exception e) {
			throw new DataAccessException(ErrorCode.AUTH01,e);
		}finally {
			jdt.close(pstm);
		}
		return res;
	}
	
	
	// 시퀀스를 가져온다. (리뷰 글번호)
	public int getSeq(Connection conn) {
		int result = 1;
		try {
			// 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT rv_idx.NEXTVAL FROM DUAL");
 
            pstm = conn.prepareStatement(sql.toString());
            rs = pstm.executeQuery(); // 쿼리 실행
 
            if (rs.next())    
            	result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        jdt.close(pstm);
        return result;
    } 
	
	// 리뷰 디테일
	public Review selectReviewDetail(Connection conn, String rvListIdx) {
		Review review = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select "
				+ "rv_idx,rv_list_id,rv_res_date,review,rv_user_id, rating "
				+ "from tb_review "
				+ "where rv_idx = ? ";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, rvListIdx);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				review = new Review();
				review.setRvIdx(rs.getInt(1));
				review.setRvListId(rs.getString(2));
				review.setRvResDate(rs.getDate(3));
				review.setReview(rs.getString(4));
				review.setRvUserId(rs.getString(5));
				review.setRating(rs.getString(6));
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.AUTH01, e);
		}finally {
			jdt.close(rs, pstm);
		}
		
		return review;
	}
	
	// 리뷰 삭제
	public int deleteReview(Connection conn, String rvUserId){
		int res = 0;
		PreparedStatement pstm = null;
		
		try {
			String query = "delete from tb_review where rv_user_id = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, rvUserId);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
		// 리뷰 리스트
		public ArrayList<Review> selectReviewList(Connection conn){
		
		ArrayList<Review> reviewList = new ArrayList<Review>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from tb_review";
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Review review = new Review();
				review.setRvIdx(rset.getInt("rv_idx"));
				review.setRvListId(rset.getString("rv_list_id"));
				review.setRvUserId(rset.getString("rv_user_id"));
				review.setReview(rset.getString("review"));
				review.setRvResDate(rset.getDate("rv_res_date"));
				review.setRating(rset.getString("rating"));
				
				reviewList.add(review);
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM01,e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return reviewList;
	}
		
		
		
		
	
}
