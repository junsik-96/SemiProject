package semiproject.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import semiproject.board.model.vo.Diary;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.common.util.file.FileVo;

public class DiaryDao {
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	
	public void insertDiary(Connection conn,Diary diary) {	
		String sql = "insert into tb_diary "
				+ "(dr_idx,user_id,content) "
				+ "values(sc_diary.nextval,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, diary.getUserId());
			pstm.setString(2, diary.getContent());
			
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
}
