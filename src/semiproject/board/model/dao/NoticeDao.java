package semiproject.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semiproject.board.model.vo.Board;
import semiproject.board.model.vo.Notice;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;

public class NoticeDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public List<Notice> selectNoticeList(Connection conn){
		List<Notice> nList = new ArrayList<Notice>();
		Notice notice = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
			String query = "select * "
					+ "from tb_notice "
					+ "order by reg_date desc";
			pstm = conn.prepareStatement(query);
			rset =  pstm.executeQuery();
			while(rset.next()) {
				notice = new Notice();
				notice.setnIdx(rset.getInt("n_idx"));
				notice.setTitle(rset.getString("title"));
				notice.setUserId(rset.getString("user_id"));
				notice.setRegDate(rset.getDate("reg_date"));
				notice.setCount(rset.getInt("count"));
				notice.setContent(rset.getString("content")); 
				nList.add(notice);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		return nList;
		
	}
	
	public Notice selectByIdx(Connection conn, int idx) {
		Notice notice = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
			
		try {
			String query = "select * from tb_notice where n_idx = ?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idx);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setnIdx(rset.getInt("n_idx"));
				notice.setTitle(rset.getString("title"));
				notice.setUserId(rset.getString("user_id"));
				notice.setRegDate(rset.getDate("reg_date"));
				notice.setCount(rset.getInt("count"));
				notice.setContent(rset.getString("content")); 
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		return notice;
	}
}
