package semiproject.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.member.model.vo.Member;

public class MemberDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Member memberAuthenticate(Connection conn, String userId, String password){
		
		Member member = null;
		
		//쿼리 실행용 객체
		PreparedStatement pstm = null;
		
		//Select쿼리의 결과로 반환된 데이터를 저장하는 객체
		ResultSet rset = null;
		
		try {
			
			String query = "select * from tb_member where user_id = ? and password = ?";
			
			//3. 쿼리 실행용 객체 생성
			pstm = conn.prepareStatement(query);
			
			//4. PreparedStatement의 쿼리를 완성
			// setString(int idx, String val) : idx번째 물음표에 val 를 넣겠다.
			pstm.setString(1, userId);
			pstm.setString(2, password);
			
			//5. 쿼리를 실행하고 질의결과(ResultSet) 을 받음
			rset = pstm.executeQuery();
			
			//6. resultSet에 저장된 데이터를 VO객체로 옮겨담기
			//next() : 현재 위치에서 다음 row에 데이터가 있는 지 확인하고 커서를 이동
			// 다음 row에 데이터가 있다면 true, 없으면  false를 반환
			if(rset.next()) {
				member = new Member();
				//현재 row의 user_id 컬럼값을 자바의 String타입으로 가져온다.
				member.setUserId(rset.getString("user_id"));
				member.setPassword(rset.getString("password"));
				member.setUserType(rset.getString("user_type"));
				member.setEmail(rset.getString("email"));
				member.setName(rset.getString("name"));
				member.setBirth(rset.getString("birth"));
				member.setTel(rset.getString("tel"));
				member.setManager(rset.getInt("manager"));
				member.setConcern(rset.getString("concern"));
				member.setListType(rset.getString("list_type"));
				member.setRegDate(rset.getDate("reg_date"));
			}
		//SQLException : db와 통신 중에 발생하는 모든 예외를 담당하는 Exception	
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM02,e);
		} finally {
			jdt.close(rset, pstm);
		}
		
		return member;
	}
	
	public Member selectMemberById(Connection conn, String userId){
		
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from tb_member where user_id = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("user_id"));
				member.setPassword(rset.getString("password"));
				member.setUserType(rset.getString("user_type"));
				member.setEmail(rset.getString("email"));
				member.setName(rset.getString("name"));
				member.setBirth(rset.getString("birth"));
				member.setTel(rset.getString("tel"));
				member.setManager(rset.getInt("manager"));
				member.setConcern(rset.getString("concern"));
				member.setListType(rset.getString("list_type"));
				member.setRegDate(rset.getDate("reg_date"));
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM01,e);
		} finally {
			jdt.close(rset,pstm);
		}
		
		return member;
	}
	
	public int insertMember(Connection conn, Member member){
		
		int res = 0;
		PreparedStatement pstm = null;
		
		try {
			String query = "insert into tb_member(user_id, password, email, name, tel, "
					+ "user_type, birth, concern, list_type) "
					+"values(?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getUserId());
			pstm.setString(2,member.getPassword());
			pstm.setString(3, member.getEmail());
			pstm.setString(4, member.getName());
			pstm.setString(5, member.getTel());
			pstm.setString(6, member.getUserType());
			pstm.setString(7, member.getBirth());
			pstm.setString(8, member.getConcern());
			pstm.setString(9, member.getListType());;
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01,e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
	public int updateMember(Connection conn, Member member){
		int res = 0;
		PreparedStatement pstm = null;
		
		try {
			String query = "update tb_member set name=?, concern=?, list_type=?, tel=? where user_id = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getName());
			pstm.setString(2, member.getConcern());
			pstm.setString(3, member.getListType());
			pstm.setString(4, member.getTel());
			pstm.setString(5, member.getUserId());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.UM01,e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}

}
