package semiproject.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.payment.model.vo.Payment;
import semiproject.reservation.model.vo.Reservation;

public class MypageDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	//찜목록 - userId로 카트에 담긴 listId 배열 반환
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
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return listIdArr;
	}
	
	//찜목록 - listId로 해당 상담사 정보 반환
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
			}
		//SQLException : db와 통신 중에 발생하는 모든 예외를 담당하는 Exception	
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return listener;
		
	}
	
	//예약 내역
	public ArrayList<Reservation> selectReservationById(Connection conn, String userId) {
		
		ArrayList<Reservation> reservationArr = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			String query = "select * from tb_reservation where res_user_id = ?";

			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);

			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Reservation reservation = new Reservation();
				reservation.setResIdx(rset.getInt("res_idx"));
				reservation.setResListId(rset.getString("res_list_id"));
				reservation.setResUserId(rset.getString("res_user_id"));
				reservation.setResDate(rset.getDate("res_date"));
				reservation.setResState(rset.getString("res_state"));
				reservation.setResAmt(rset.getInt("res_amt"));

				reservationArr.add(reservation);
			}
		//SQLException : db와 통신 중에 발생하는 모든 예외를 담당하는 Exception	
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return reservationArr;
		
	}
	
	//결제 내역
	public ArrayList<Payment> selectPayment(Connection conn, int resIdx) {
		
		ArrayList<Payment> payArr = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			String query = "select * from tb_payment where res_idx = ?";

			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, resIdx);

			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Payment payment = new Payment();
				payment.setRes_idx(rset.getInt("res_idx"));
				payment.setPm_idx(rset.getInt("pm_idx"));
				payment.setPm_state(rset.getString("pm_state"));
				payment.setPm_date(rset.getDate("pm_date"));
				payment.setAmount(rset.getInt("amount"));
				payArr.add(payment);
			}
		//SQLException : db와 통신 중에 발생하는 모든 예외를 담당하는 Exception	
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return payArr;
		
	}
	
}
