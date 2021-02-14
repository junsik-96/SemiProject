package semiproject.listener.model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.listener.model.vo.School;
import semiproject.listener.model.vo.Class;
import semiproject.listener.model.vo.FindListener;

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
		Array licenArray = null;

		try {
			String query = "update tb_listener set LIST_GEN = ?, TYPE = ?, LIST_SCHOOL = ?, LIST_CLASS = ?, LIST_LICENSE = ?,LIST_FIELD = ?, LIST_JOB = ?  where LIST_ID = ?";
				
			pstm = conn.prepareStatement(query);
			pstm.setString(1, listener.getListGen());
			pstm.setString(2, listener.getType());
			pstm.setString(3, listener.getListSchool());
			pstm.setString(4, listener.getListClass());
			pstm.setString(5, Arrays.toString(listener.getListLicense()));
			pstm.setString(6, listener.getListField());
			pstm.setString(7, Arrays.toString(listener.getListJob()));
			pstm.setString(8, listener.getListId());
			
			res = pstm.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IL01, e);
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
	
	public List<Listener> selectListenerBySearch(Connection conn,String who) {
		List<Listener> listenerList = new ArrayList<Listener>();
		Listener listener = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		 
		try {
			String query = "select * from tb_listener l "
					+ "inner join tb_member m "
					+ "on(l.list_id = m.user_id) "
					+ "where (name like '%'||?||'%' or "
					+ "list_field like '%'||?||'%' or "
					+ "list_gen like '%'||?||'%' or "
					+ "type like '%'||?||'%' or "
					+ "list_job like '%'||?||'%') "
					+ "and list_is_true = 'Y'";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, who);
			pstm.setString(2, who); 
			pstm.setString(3, who); 
			pstm.setString(4, who); 
			pstm.setString(5, who); 
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				listener = new Listener();
				listener.setListName(rset.getString("name"));
				listener.setListGen(rset.getString("list_gen"));
				listener.setListField(rset.getString("list_field"));
				listener.setType(rset.getString("type"));
				listener.setListPhone(rset.getString("tel")); 
				listener.setListEmail(rset.getString("email"));
				listener.setListResCnt(rset.getInt("list_res_cnt"));
				listener.setListLikely(rset.getInt("list_likely"));			
				
				listenerList.add(listener);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SL02, e);
		}finally {
			jdt.close(rset,pstm);
		}	
		return listenerList;
	}
	
	public List<Listener> selectListenerByCheck(Connection conn, FindListener findlistener){
		
		List<Listener> listenerList = new ArrayList<Listener>();
		Listener flistener = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
				
		try {
			String query = "select * from tb_listener l inner join tb_member m "
					+ "on(l.list_id = m.user_id) where type = ? and "
					+ "list_gen = ? and list_field = ? and list_amt between 0 and ?"
					+ "and NVL(trunc(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(BIRTH,1,4),'YYYY'))/12),0) between ? and (?+9)";
			pstm = conn.prepareStatement(query);
			for(int i=0; i<findlistener.getListType().length; i++) {	
				pstm.setString(1,findlistener.getListType()[i]);
				for(int j=0; j<findlistener.getListGen().length; j++) {
					pstm.setString(2,findlistener.getListGen()[j]);
					for(int z=0; z<findlistener.getListField().length; z++) {
						pstm.setString(3,findlistener.getListField()[z]);
						for(int k=0; k<findlistener.getListPrice().length; k++) {
							pstm.setInt(4, findlistener.getListPrice()[k]);
							for(int n=0; n<findlistener.getListAge().length; n++) {
								pstm.setInt(5, findlistener.getListAge()[n]);
								pstm.setInt(6, findlistener.getListAge()[n]);
								
								rset = pstm.executeQuery();
								while(rset.next()) {
									flistener = new Listener();
									flistener.setListName(rset.getString("name"));
									flistener.setListGen(rset.getString("list_gen"));
									flistener.setListField(rset.getString("list_field"));
									flistener.setType(rset.getString("type"));
									flistener.setListPhone(rset.getString("tel")); 
									flistener.setListEmail(rset.getString("email"));
									flistener.setListResCnt(rset.getInt("list_res_cnt"));
									flistener.setListLikely(rset.getInt("list_likely"));
									flistener.setListAmt(rset.getInt("list_amt"));
									
									listenerList.add(flistener);
								}	
							}
						}				
					}				
				}	
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SL02, e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return listenerList;
	}
	
	public List<Listener> selectListenerAll(Connection conn){
		
		List<Listener> listenerList = new ArrayList<Listener>();
		Listener listener = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
			String query = "select * from tb_listener l inner join tb_member m "
					+ "on(l.list_id = m.user_id)";
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				listener = new Listener();
				listener.setListName(rset.getString("name"));
				listener.setListGen(rset.getString("list_gen"));
				listener.setListField(rset.getString("list_field"));
				listener.setType(rset.getString("type"));
				listener.setListPhone(rset.getString("tel")); 
				listener.setListEmail(rset.getString("email"));
				listener.setListResCnt(rset.getInt("list_res_cnt"));
				listener.setListLikely(rset.getInt("list_likely"));			
				
				listenerList.add(listener);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SL02, e);
		}finally {
			jdt.close(rset,pstm);
		}
		
		return listenerList;
	}
	
	
	
}
