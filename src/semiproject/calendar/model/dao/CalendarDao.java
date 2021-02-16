package semiproject.calendar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semiproject.calendar.model.vo.Calendar;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.reservation.model.vo.Reservation;

public class CalendarDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 상담사 >> 예약받은리스트 >> 캘린더로
	public ArrayList<Calendar> selectResDetail(Connection conn, String listId){
		
		ArrayList<Calendar> resList = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from tb_reservation where res_list_id = ?";
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, listId);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Calendar calendar = new Calendar();
				calendar.setResListId(rset.getString("res_list_id"));
				calendar.setResUserId(rset.getString("res_user_id"));
				calendar.setResDate(rset.getString("res_date"));
				
				resList.add(calendar);
			}
		} catch (SQLException e){
			throw new DataAccessException(ErrorCode.SM01,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return resList;
	}
	
	
	
}
