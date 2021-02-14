package semiproject.payment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;


public class PaymentDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	//상담사 정보 불러오기 (프로필, 이름, 가격)
	   public void insertInfo(Connection conn, Listener listener) {
	      String sql = "insert into tb_listener "
	            + "(list_pro,list_name,list_amt) "
	            + "values('b'||sc_board_idx.nextval,?,?,?)"; ///////////
	      PreparedStatement pstm = null;
	      try {
	         pstm = conn.prepareStatement(sql);
	         pstm.setString(1, listener.getListPro());
	         pstm.setString(2, listener.getListName());
	         pstm.setInt(3, listener.getListAmt());
	         pstm.executeUpdate();
	      } catch (SQLException e) {
	         throw new DataAccessException(ErrorCode.NOLIST, e);
	      }finally {
	         jdt.close(pstm);
	      }
	      
	      
	   }
	   
}
