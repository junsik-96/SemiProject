
package semiproject.index.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.find.model.vo.Listener;

public class IndexDao {

JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	// 예약건수 랭킹
	public Listener selectByResCnt(Connection conn, int ranking) {
		
		Listener listener = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;		
		
		
		try {
			String sql = "select \r\n"
					+ "* \r\n"
					+ "from (\r\n"
					+ "select LIST_PRO,LIST_FIELD,TYPE,NAME,list_res_cnt, rank() over(order by list_res_cnt desc) as res     \r\n"
					+ " from \r\n"
					+ " tb_listener l inner join tb_member m on(l.list_id = m.user_id)\r\n"
					+ " )\r\n"
					+ "where res = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ranking);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				listener = new Listener();
				listener.setListPro(rset.getString(1));
				listener.setListField(rset.getString(2));
				listener.setType(rset.getString(3));
				listener.setListName(rset.getString(4)); 
				listener.setListResCnt(rset.getInt(5));
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SL01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		 
		return listener;
	}
	
		// 추천수 랭킹
		public Listener selectByLikeCnt(Connection conn, int ranking) {
			
			Listener listener = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;		
			
			
			try {
				String sql = "select \r\n"
						+ "* \r\n"
						+ "from (\r\n"
						+ "select LIST_PRO,LIST_FIELD,TYPE,NAME,list_likely, rank() over(order by list_likely desc) as res     \r\n"
						+ " from \r\n"
						+ " tb_listener l inner join tb_member m on(l.list_id = m.user_id)\r\n"
						+ " )\r\n"
						+ "where res = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ranking);
				rset = pstm.executeQuery();
				
				if(rset.next()) {
					listener = new Listener();
					listener.setListPro(rset.getString(1));
					listener.setListField(rset.getString(2));
					listener.setType(rset.getString(3));
					listener.setListName(rset.getString(4)); 
					listener.setListLikely(rset.getInt(5)); 
				}
				
			} catch (SQLException e) {
				throw new DataAccessException(ErrorCode.SL01, e);
			}finally {
				jdt.close(rset,pstm);
			}
			 
			return listener;
		}
		
		// 추천수 랭킹
		public Listener selectByRegDate(Connection conn, int ranking) {
			
			Listener listener = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;		
			
			
			try {
				String sql = "select * from (select LIST_PRO,LIST_FIELD,TYPE,NAME,\r\n"
						+ "LIST_REGDATE, rank() over(order by LIST_REGDATE desc) as reg"
						+ " from \r\n"
						+ " tb_listener l inner join tb_member m on(l.list_id = m.user_id)\r\n"
						+ " )\r\n"
						+ "where reg = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ranking);
				rset = pstm.executeQuery();
				
				if(rset.next()) {
					listener = new Listener();
					listener.setListPro(rset.getString(1));
					listener.setListField(rset.getString(2));
					listener.setType(rset.getString(3));
					listener.setListName(rset.getString(4)); 
					listener.setListRegDate(rset.getDate(5));
				}
				
			} catch (SQLException e) {
				throw new DataAccessException(ErrorCode.SL01, e);
			}finally {
				jdt.close(rset,pstm);
			}
			 
			return listener;
		}
	
		
	
}
