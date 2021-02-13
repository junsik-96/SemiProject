package semiproject.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.find.model.vo.Listener;

public class MypageDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public ArrayList<Listener> selectListener(Connection conn, String userId) {
		
		ArrayList<Listener> listIdArr = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			String query = "select * from tb_cart where user_id = ?";

			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);

			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Listener listener = new Listener();
				listener.setListId(rset.getString("list_id"));
				listIdArr.add(listener);
			}
		//SQLException : db와 통신 중에 발생하는 모든 예외를 담당하는 Exception	
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return listIdArr;
	}
	
	public Listener selectListenerById(Connection conn, String listId) {
		
		Listener listener = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			String query = "select * from tb_listener where list_id = ?";

			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, listId);

			rset = pstm.executeQuery();
			
			if(rset.next()) {
				listener = new Listener();
				listener.setListId(rset.getString("list_id"));
				listener.setListGen(rset.getString("list_gen"));
				listener.setListPro(rset.getString("list_pro"));
				listener.setListField(rset.getString("list_field"));
				listener.setType(rset.getString("type"));
				listener.setListAmt(rset.getInt("list_amt"));
				listener.setListIsTrue(rset.getString("list_is_true"));
				listener.setListLikely(rset.getInt("list_likely"));
				listener.setListResCnt(rset.getInt("list_res_cnt"));
				listener.setListRegDate(rset.getDate("list_regdate"));
				listener.setListSchool(rset.getString("list_school"));
				listener.setListClass(rset.getString("list_class"));
				listener.setListLicense(rset.getString("list_license"));
				listener.setListJob(rset.getString("list_job"));
			}
		//SQLException : db와 통신 중에 발생하는 모든 예외를 담당하는 Exception	
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return listener;
		
	}
}
