package semiproject.payment.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.payment.model.vo.Payment;


public class PaymentDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public PaymentDao() {
		
	}
	
	//상담사 정보 불러오기 (프로필, 이름, 가격)
	   public Payment insertInfo(Connection conn, String ListPro, String ListName, int ListAmt) {
		   
		   Payment payment = null;
		   PreparedStatement pstm = null;
		   ResultSet rset = null;
		   
	      try {
	    	  
	    	 String query = "select * from tb_listener where list_pro = ? and list_name = ? and list_amt = ?";
	         
	    	 pstm = conn.prepareStatement(query);
	         pstm.setString(1, ListPro);
	         pstm.setString(2, ListName);
	         pstm.setInt(3, ListAmt);
	         pstm.executeUpdate();
	         
	         rset = pstm.executeQuery();
	         
	         if(rset.next()) {
	        	 payment = new Payment();
	        	 
	        	 payment.setPmIdx(rset.getInt("pm_idx"));
	        	 payment.setResIdx(rset.getInt("res_idx"));
	        	 payment.setPmState(rset.getNString("pm_state"));
	        	 payment.setPmDate(rset.getDate("pm_date"));
	        	 payment.setAmount(rset.getInt("amount"));
	        	 
	         }
	         
	      } catch (SQLException e) {
	         throw new DataAccessException(ErrorCode.PAY_404, e);
	      }finally {
	         jdt.close(rset,pstm);
	      }
	      
	      return payment;
	      
	   }
	   
}
