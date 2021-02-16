package semiproject.index.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.listener.model.vo.Listener;
import semiproject.member.model.vo.Member;

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
					+ "select LIST_PRO,LIST_FIELD,TYPE,NAME,list_id,list_res_cnt, rank() over(order by list_res_cnt desc) as res     \r\n"
					+ " from \r\n"
					+ " tb_listener l inner join tb_member m on(l.list_id = m.user_id)\r\n"
					+ " )\r\n"
					+ "where res = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ranking);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				listener = new Listener();
				listener.setListPro(rset.getString("list_pro"));
				listener.setListField(rset.getString("list_field"));
				listener.setType(rset.getString("type"));
				listener.setListName(rset.getString("name")); 
				listener.setListResCnt(rset.getInt("list_res_cnt"));
				listener.setListId(rset.getString("list_id"));
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
						+ "select LIST_PRO,LIST_FIELD,TYPE,NAME,list_id,list_likely, rank() over(order by list_likely desc) as res     \r\n"
						+ " from \r\n"
						+ " tb_listener l inner join tb_member m on(l.list_id = m.user_id)\r\n"
						+ " )\r\n"
						+ "where res = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ranking);
				rset = pstm.executeQuery();
				
				if(rset.next()) {
					listener = new Listener();
					listener.setListPro(rset.getString("list_pro"));
					listener.setListField(rset.getString("list_field"));
					listener.setType(rset.getString("type"));
					listener.setListName(rset.getString("name"));
					listener.setListLikely(rset.getInt("list_likely")); 
					listener.setListId(rset.getString("list_id"));
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
				String sql = "select * from (select LIST_PRO,LIST_FIELD,list_id,list_is_true,TYPE,NAME,\r\n"
						+ "LIST_REGDATE, rank() over(order by LIST_REGDATE desc) as reg"
						+ " from \r\n"
						+ " tb_listener l inner join tb_member m on(l.list_id = m.user_id) where list_is_true = 'Y'\r\n"
						+ " )\r\n"
						+ "where reg = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ranking);
				rset = pstm.executeQuery();
				
				if(rset.next()) {
					listener = new Listener();
					listener.setListPro(rset.getString("list_pro")); 
					listener.setListField(rset.getString("list_field"));
					listener.setType(rset.getString("type"));
					listener.setListName(rset.getString("name"));
					listener.setListRegDate(rset.getDate("list_regdate"));
					listener.setListId(rset.getString("list_id"));
				}
				
			} catch (SQLException e) {
				throw new DataAccessException(ErrorCode.SL01, e);
			}finally {
				jdt.close(rset,pstm);
			}
			 
			return listener;
		}
	
		public List<Listener> selectLisByComm(Connection conn, Listener listener){
			Listener alistener = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			List<Listener> commListener = new ArrayList<Listener>();
		
			
			try {
				String query = "select * from "
						+ "tb_listener l inner join tb_member m "
						+ "on(l.list_id = m.user_id) where "
						+ "list_field = ? or type = ? "
						+ "order by list_likely desc";
				pstm = conn.prepareStatement(query);
				pstm.setString(1, listener.getListField());
				pstm.setString(2, listener.getType());
				rset = pstm.executeQuery();
				
				while(rset.next()) {
					alistener = new Listener();
					alistener.setListName(rset.getString("name"));
					alistener.setListGen(rset.getString("list_gen"));
					alistener.setListField(rset.getString("list_field"));
					alistener.setType(rset.getString("type"));
					alistener.setListPhone(rset.getString("tel")); 
					alistener.setListEmail(rset.getString("email"));
					alistener.setListResCnt(rset.getInt("list_res_cnt"));
					alistener.setListLikely(rset.getInt("list_likely"));	
					alistener.setListId(rset.getString("list_id"));
					alistener.setListPro(rset.getString("list_pro"));
					
					commListener.add(alistener);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commListener;
		}
	
}
