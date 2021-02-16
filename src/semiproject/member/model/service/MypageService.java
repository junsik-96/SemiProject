package semiproject.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.member.model.dao.MypageDao;
import semiproject.member.model.vo.Cart;
import semiproject.member.model.vo.Likey;
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
	
	//찜목록 추가
	public int insertHold(Cart cart) {
		Connection conn = jdt.getConnection();
		int res = 0;

		try {
			 res = mypageDao.insertHold(conn, cart);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	//찜목록 삭제
	public int DeleteHold(Cart cart) {
		Connection conn = jdt.getConnection();
		int res = 0;

		try {
			 res = mypageDao.DeleteHold(conn, cart);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	//추천
	public int likey(Likey likey) {
		Connection conn = jdt.getConnection();
		int res = 0;

		try {
			 res = mypageDao.likey(conn, likey);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	public void addLikey(String listId) {
		Connection conn = jdt.getConnection();

		try {
			 mypageDao.addLikey(conn, listId);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}

	}

}
