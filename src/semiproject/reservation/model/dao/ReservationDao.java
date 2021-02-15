package semiproject.reservation.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.reservation.model.vo.Reservation;


public class ReservationDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public ReservationDao() {
		
	}
	
	   public Reservation insertInfo(Connection conn, String resListId, String resUserId) {
		   
		   Reservation reservation = null;
		   PreparedStatement pstm = null;
		   ResultSet rset = null;
		   
	      try {
	    	  
	    	 String query = "select * from tb_listener where listPro = ? and listName = ? and listAmt = ?";
	         
	    	 pstm = conn.prepareStatement(query);
	         pstm.setString(1, resListId);
	         pstm.setString(2, resUserId);
	         pstm.executeUpdate();
	         
	         rset = pstm.executeQuery();
	         
	         if(rset.next()) {
	        	 reservation = new Reservation();
	        	 
	        	 reservation.setResIdx(rset.getInt("res_idx"));
	        	 reservation.setResListId(rset.getString("res_list_id"));
	        	 reservation.setResUserId(rset.getNString("res_user_id"));
	        	 reservation.setResDate(rset.getDate("res_date"));
	        	 reservation.setResState(rset.getNString("res_state"));
	        	 reservation.setResAmt(rset.getInt("res_amt"));
	        	 
	         }
	      } catch (SQLException e) {
	         throw new DataAccessException(ErrorCode.NOLIST, e);
	      }finally {
	         jdt.close(pstm);
	      }
	      
	      return reservation;
	      
	   }
	   
}
