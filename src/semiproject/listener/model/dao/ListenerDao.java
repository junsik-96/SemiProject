package semiproject.listener.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.School;

public class ListenerDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public School selectListBySchool(Connection conn, String school) {
		
		School schoolName = null;
		PreparedStatement pstm = null;
		ResultSet rset= null;
		
		try {
			String sql = "select * from TB_SCHOOL where SCHOOL_NAME like %?%";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, school);
			
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				schoolName = new School();
				schoolName.setSchoolName(rset.getString("SCHOOL_NAME"));
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.FS01, e);
		}finally {
			jdt.close(rset,pstm);
		}
	
		return schoolName;
	}
	
	
}
