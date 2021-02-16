package semiproject.payment.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.payment.model.vo.Payment;


public class PaymentDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public PaymentDao() {
		
	}
	
	//상담사 정보 불러오기 (프로필, 이름, 가격)
	public Listener insertInfo(Connection conn, String ListPro, String ListName, int ListAmt) {
		   
		   Listener listener = null;
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
	        	 listener = new Listener();
	        	 
	        	 listener.setListPro(rset.getString("list_pro"));
	        	 listener.setListName(rset.getString("list_name"));
	        	 listener.setListAmt(rset.getInt("list_amt"));
	        	 
	         }
	         
	      } catch (SQLException e) {
	         throw new DataAccessException(ErrorCode.NOLIST, e);
	      }finally {
	         jdt.close(rset,pstm);
	      }
	      
	      return listener;
	      
	   }
	
	   public Payment paying(Connection conn, int pmIdx, Date pmDate, int amount) {
		   
		   Payment payment = null;
		   PreparedStatement pstm = null;
		   ResultSet rset = null;
		   
	      try {
	    	  
	    	 String query = "select * from tb_payment where pm_idx = ? and pm_date = ? and amount = ?";
	         
	    	 pstm = conn.prepareStatement(query);
	         pstm.setInt(1, pmIdx);
	         pstm.setDate(2, pmDate);
	         pstm.setInt(3, amount);
	         pstm.executeUpdate();
	         
	         rset = pstm.executeQuery();
	         
	         if(rset.next()) {
	        	 payment = new Payment();
	        	 
	        	 payment.setPmIdx(rset.getInt("pm_idx"));
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