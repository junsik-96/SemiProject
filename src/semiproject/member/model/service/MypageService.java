package semiproject.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.member.model.dao.MypageDao;
import semiproject.payment.model.vo.Payment;
import semiproject.reservation.model.vo.Reservation;


public class MypageService {
	
	MypageDao mypageDao = new MypageDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	//찜목록 - userId로 카트에 담긴 listId 배열 반환
	public ArrayList<Listener> selectListener(String userId) {
		Connection conn = jdt.getConnection();
		
		ArrayList<Listener> listIdArr = null;
		
		try {
			listIdArr = mypageDao.selectListener(conn, userId);
		} finally {
			jdt.close(conn);
		}
		
		return listIdArr;
	}
	
	//찜목록 - listId로 해당 상담사 정보 반환
	public Listener selectListenerById(String listId) {
		Connection conn = jdt.getConnection();
		
		Listener listener = null;
		
		try {
			listener = mypageDao.selectListenerById(conn, listId);
		} finally {
			jdt.close(conn);
		}
		
		return listener;
	}
	
	//예약내역
	public ArrayList<Reservation> selectReservationById(String userId) {
		Connection conn = jdt.getConnection();
		
		ArrayList<Reservation> reservationArr = null;
		
		try {
			reservationArr = mypageDao.selectReservationById(conn, userId);
		} finally {
			jdt.close(conn);
		}
		
		return reservationArr;
	}
	
	//결제내역
	public ArrayList<Payment> selectPayment(int resIdx) {
		Connection conn = jdt.getConnection();
		
		ArrayList<Payment> payArr = new ArrayList<>();
		
		try {
			payArr = mypageDao.selectPayment(conn, resIdx);
		} finally {
			jdt.close(conn);
		}
		
		return payArr;
	}

}
