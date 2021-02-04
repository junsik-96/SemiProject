package semiproject.member.model.service;

import java.sql.Connection;

import semiproject.common.template.JDBCTemplate;
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
}
