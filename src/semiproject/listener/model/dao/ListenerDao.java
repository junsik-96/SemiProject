package semiproject.listener.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.find.model.vo.Listener;
import semiproject.listener.model.vo.School;
import semiproject.listener.model.vo.Class;

public class ListenerDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public List<School> selectListBySchool(Connection conn, String school) {
		List<School> schoolList = new ArrayList<School>();
		School schoolName = null;
		PreparedStatement pstm = null;
		ResultSet rset= null;
		
		try {	
			String sql = "select * from TB_SCHOOL where SCHOOL_NAME like '%'||?||'%'";
			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, school);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				schoolName = new School();
				schoolName.setSchoolName(rset.getString("SCHOOL_NAME"));
			
				schoolList.add(schoolName);
			} 
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.FS01, e);
		}finally {
			jdt.close(rset,pstm);
		} 
	
		return schoolList;
	}
	
	public List<Class> selectListByClass(Connection conn, String class1) {
		List<Class> classlList = new ArrayList<Class>();
		Class classlName = null;
		PreparedStatement pstm = null;
		ResultSet rset= null;
		
		try {	
			String sql = "select * from TB_CLASS where CLASS_NAME like '%'||?||'%'";
			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, class1);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				classlName = new Class();
				classlName.setClassName(rset.getString("CLASS_NAME"));
			
				classlList.add(classlName);
			} 
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.CS01, e);
		}finally {
			jdt.close(rset,pstm);
		} 
	
		return classlList;
	}
	
	public int updateListener(Connection conn, Listener listener) {
		int res = 0;
		PreparedStatement pstm = null;
		
		
		try {
			String query = "update tb_listener set LIST_GEN = ?, TYPE = ?, LIST_SCHOOL = ?, LIST_CLASS = ?, LIST_LICENSE = ?,LIST_FIELD = ?, LIST_JOB = ?  where LIST_ID = 'jun12345'";
					
			pstm = conn.prepareStatement(query);
			pstm.setString(1, listener.getListGen());
			pstm.setString(2, listener.getType());
			pstm.setString(3, listener.getListSchool());
			pstm.setString(4, listener.getListClass());
			pstm.setString(5, listener.getListLicense());
			pstm.setString(6, listener.getListField());
			pstm.setString(7, listener.getListJob());
			/* pstm.setString(8, listener.getListId()); */
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IL01, e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
}
