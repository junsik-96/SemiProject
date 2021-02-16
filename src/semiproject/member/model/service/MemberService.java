package semiproject.member.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import semiproject.common.code.Code;
import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.mail.MailSender;
import semiproject.common.template.JDBCTemplate;
import semiproject.common.util.http.HttpUtil;
import semiproject.listener.model.vo.Listener;
import semiproject.member.model.dao.MemberDao;
import semiproject.member.model.vo.Member;

public class MemberService {
	
	MemberDao memberDao = new MemberDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public Member memberAuthenticate(String userId, String password){	
		Connection conn = jdt.getConnection();
		//Dao에게 userId와 password로 식별할 수 있는 회원정보를 DB에서 조회할 것을 요청
		
		Member member = null;
		
		try {
			member = memberDao.memberAuthenticate(conn, userId, password);
		} finally {
			jdt.close(conn);
		}
		return member;
	}
	
	public Member kmemberAuthenticate(String userId){	
		Connection conn = jdt.getConnection();
		
		Member member = null;
		
		try {
			member = memberDao.kmemberAuthenticate(conn, userId);
		} finally {
			jdt.close(conn);
		}
		return member;
	}
	
	public Member selectMemberById(String userId){	
		Connection conn = jdt.getConnection();
		
		Member member = null;
		
		try {
			member = memberDao.selectMemberById(conn, userId);
		} finally {
			jdt.close(conn);
		}
		return member;
	}
	
	public void authenticateEmail(Member member) {
		//POST방식으로 통신해보기
		String subject = "회원가입을 완료해주세요!";
		String htmlText = "";
		
		HttpUtil http = new HttpUtil();
		String url = Code.DOMAIN + "/mail";
		
		//header 저장
		Map<String,String> headers = new HashMap<>();
		headers.put("content-type", "application/x-www-form-urlencoded; charset=utf-8");
		
		//parameter 저장
		Map<String,String> params = new HashMap<>();
		params.put("mailTemplate", "temp_join");
		params.put("userId", member.getUserId());
		
		htmlText = http.post(url,headers,http.urlEncodedForm(params));
		
		new MailSender().sendEmail(member.getEmail(),subject,htmlText);
	}
	
	public int insertMember(Member member){
		//Transaction관리를 Service단에서 처리하기 위해 Connection을 
		//Service의 메서드에서 생성
		Connection conn = jdt.getConnection();
		int res = 0;
		
		try {
			//Dao의 메서드로 생성한 Connection을 주입
			 res = memberDao.insertMember(conn, member);
			//Dao에서 아무 문제없이 실행이 끝난다면 commit;
			jdt.commit(conn);
		}catch(DataAccessException e) {
			//Dao에서 SQLException이 발생할 경우 rollback처리
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	public int insertListener(Member member){
		//Transaction관리를 Service단에서 처리하기 위해 Connection을 
		//Service의 메서드에서 생성
		Connection conn = jdt.getConnection();
		int res = 0;
		
		try {
			//Dao의 메서드로 생성한 Connection을 주입
			 res = memberDao.insertListener(conn, member);
			//Dao에서 아무 문제없이 실행이 끝난다면 commit;
			jdt.commit(conn);
		}catch(DataAccessException e) {
			//Dao에서 SQLException이 발생할 경우 rollback처리
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	public int updateMember(Member member){
		Connection conn = jdt.getConnection();
		int res = 0;
		
		try {
			res = memberDao.updateMember(conn, member);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}
	
	public Listener listIsTrueCheck(String listId) {
		Connection conn = jdt.getConnection();
		Listener listener = null;
		
		try {
			listener = memberDao.listIsTrueCheck(conn, listId);
		} finally {
			jdt.close(conn);
		}
		return listener;
		
	}
}
