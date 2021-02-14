package semiproject.calendar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semiproject.calendar.model.vo.Calendar;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;

public class CalendarDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public CalendarDao() {}
	
	// 예약 리스트
	public ArrayList<Calendar> selectResList(Connection conn){
		
		ArrayList<Calendar> resList = new ArrayList<Calendar>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select res_list_id, res_user_id, res_date from tb_reservation";
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Calendar calendar = new Calendar();
				calendar.setResListId(rset.getString("res_list_id"));
				calendar.setResUserId(rset.getString("res_user_id"));
				calendar.setResDate(rset.getString("res_date"));
				resList.add(calendar);
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM01,e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return resList;
	}
	
	// 회원, 상담사 일치 리스트
	public List<Calendar> selectResDetail(Connection conn, String resListId){
		
		List<Calendar> resCalList = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from tb_reservation where res_list_id";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, resListId);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Calendar calendar = new Calendar();
				calendar.setResListId(rset.getString("res_list_id"));
				calendar.setResUserId(rset.getString("res_user_id"));
				calendar.setResDate(rset.getString("res_date"));
				
				resCalList.add(calendar);
			}
		} catch (SQLException e){
			throw new DataAccessException(ErrorCode.SM01,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return resCalList;
	}
	
	
	
}
