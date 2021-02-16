package semiproject.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semiproject.board.model.vo.Board;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.template.JDBCTemplate;
import semiproject.common.util.file.FileVo;

public class BoardDao {
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	
	public void insertBoard(Connection conn,Board board) {	
		String sql = "insert into tb_board "
				+ "(bd_idx,user_id,title,content,field) "
				+ "values(sc_board.nextval,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, board.getUserId());
			pstm.setString(2, board.getTitle());
			pstm.setString(3, board.getContent());
			pstm.setString(4, board.getField());
			pstm.executeUpdate();

			 
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IB01, e);
		}finally {
			jdt.close(pstm);
		}
	}	
	
	
	
	public Board selectBoardDetail(Connection conn,int bdIdx) throws SQLException{
		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select "
				+ "bd_idx,user_id,reg_date,title,content,count,field "
				+ "from tb_board "
				+ "where bd_idx = ? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, bdIdx);
		rs = pstm.executeQuery();
		
		try {
			if(rs.next()) {
				board = new Board();
				board.setBdIdx(rs.getInt(1));
				board.setUserId(rs.getString(2));
				board.setRegDate(rs.getDate(3));
				board.setTitle(rs.getString(4));
				board.setContent(rs.getString(5));
				board.setCount(rs.getInt(6));
				board.setField(rs.getString(7));
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SB01, e);
		}finally {
			jdt.close(rs,pstm);
		}
		return board;
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
	
	public List<FileVo> selectFileWithBoard(Connection conn,int bdIdx){
		List<FileVo> res = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select "
					+ "f_idx,type_idx,origin_file_name,rename_file_name,save_path,reg_date,is_del "
					+ "from tb_file "
					+ "where type_idx = ? ";
		
		try {
			res = new ArrayList<FileVo>();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bdIdx);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				FileVo fileVo = new FileVo();
				fileVo.setfIdx(rs.getInt(1));
				fileVo.setTypeIdx(rs.getString(2));
				fileVo.setOriginFileName(rs.getString(3));
				fileVo.setRenameFileName(rs.getString(4));
				fileVo.setSavePath(rs.getString(5));
				fileVo.setRegDate(rs.getDate(6));
				fileVo.setIsDel(rs.getInt(7));
				
				res.add(fileVo);
			}
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SF01, e);
		}finally {
			jdt.close(rs,pstm);
		}
		return res;
	}
	
	public void updateBoard(Connection conn, Board board){
		
		PreparedStatement pstm = null;
		
		try {
			String query = "update tb_board"
					+ " set title = ?"
					+ " , content = ?"
					+ " where bd_idx = ?";
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getContent());
			pstm.setInt(3, board.getBdIdx());
			
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.SM01,e);
		}finally {
			jdt.close(pstm);
		}
	}
	
	public List<Board> selectBoardInfo(Connection conn){
		List<Board> bList = new ArrayList<Board>();
		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
			String query = "select bd_idx,title,user_id,reg_date,count from tb_board "
					+ "order by reg_date desc";
			pstm = conn.prepareStatement(query);
			rset =  pstm.executeQuery();
			while(rset.next()) {
				board = new Board();
				board.setBdIdx(rset.getInt("bd_idx"));
				board.setTitle(rset.getString("title")); 
				board.setUserId(rset.getString("user_id"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setCount(rset.getInt("count"));
				bList.add(board);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		return bList;
		
	}
	
	public Board selectByIdx(Connection conn, int idx) {
		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
			
		try {
			String query = "select * from tb_board where bd_idx = ?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idx);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				board = new Board();
				board.setUserId(rset.getString("user_id"));
				board.setTitle(rset.getString("title")); 
				board.setRegDate(rset.getDate("reg_date"));
				board.setField(rset.getString("field")); 
				board.setContent(rset.getString("content")); 
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(ErrorCode.IM01, e);
		}finally {
			jdt.close(rset,pstm);
		}
		return board;
	}
}
