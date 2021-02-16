package semiproject.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semiproject.board.model.vo.Board;
import semiproject.board.model.vo.Diary;
import semiproject.board.model.vo.Notice;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.common.util.file.FileVo;

public class DiaryDao {
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	
	public void insertDiary(Connection conn,Diary diary) {	
		PreparedStatement pstm = null;
		try {
			String sql = "insert into tb_diary "
					+ "(dr_idx,user_id,title,content) "
					+ "values(sc_diary.nextval,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, diary.getUserId());
			pstm.setString(2, diary.getTitle());
			pstm.setString(3, diary.getContent());
			
			pstm.executeUpdate();

			 
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IB01, e);
		}finally {
			jdt.close(pstm);
		}
	}	
	
	public void insertFile(Connection conn, FileVo fileVo) {
		String typeIdx = "";
		//1.새로 등록되는 게시글의 파일정보를 저장
		//typeIdx의 값이 sequence의 currval
		if(fileVo.getTypeIdx() == null) {
			typeIdx = "'b'|| sc_board_idx.currval";
		}else {
			typeIdx = "'" + fileVo.getTypeIdx() + "'";
		}
		
		String sql = "insert into tb_file "
				+ "(f_idx,type_idx,origin_file_name,rename_file_name,save_path) "
				+ "values(sc_file_idx.nextval," + typeIdx + ",?,?,?) ";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, fileVo.getOriginFileName());
			pstm.setString(2, fileVo.getRenameFileName());
			pstm.setString(3, fileVo.getSavePath());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IF01, e);
		}finally {
			jdt.close(pstm);
		}
	}
	
	public List<Diary> selectDiaryList(Connection conn, String userId){
		List<Diary> dList = new ArrayList<Diary>();
		Diary diary = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
			String query = "select * "
					+ "from tb_diary "
					+ "where user_id = ? "
					+ "order by reg_date desc";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset =  pstm.executeQuery();
			while(rset.next()) {
				diary = new Diary();
				diary.setDrIdx(rset.getInt("dr_idx"));
				diary.setUserId(rset.getString("user_id"));
				diary.setContent(rset.getString("content"));
				diary.setRegDate(rset.getDate("reg_date"));
				diary.setTitle(rset.getString("title"));
				dList.add(diary);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		return dList;
		
	}
	
	public Diary selectByIdx(Connection conn, int idx) {
		Diary diary = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
			
		try {
			String query = "select * from tb_diary where dr_idx = ?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idx);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				diary = new Diary();
				diary.setDrIdx(rset.getInt("dr_idx"));
				diary.setUserId(rset.getString("user_id"));
				diary.setContent(rset.getString("content"));
				diary.setRegDate(rset.getDate("reg_date"));
				diary.setTitle(rset.getString("title"));
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		return diary;
	}
	  
}
