package semiproject.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import semiproject.board.model.dao.BoardDao;
import semiproject.board.model.vo.Board;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.common.util.file.FileUtil;
import semiproject.common.util.file.FileVo;

public class BoardService {
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	BoardDao boardDao = new BoardDao();
	
	public void insertBoard(String userId,HttpServletRequest request) {
		Connection conn = jdt.getConnection();
		
		Map<String,List> boardData = new FileUtil().fileUpload(request);
		Board board = new Board();
		board.setUserId(userId);
		board.setTitle(boardData.get("title").get(0).toString());
		board.setContent(boardData.get("content").get(0).toString());
		board.setField(boardData.get("field").get(0).toString());
	
		try {
			boardDao.insertBoard(conn, board);
			List<FileVo> files = boardData.get("fileData");
			for(FileVo fileVo : files) {
				boardDao.insertFile(conn, fileVo);
			}
			jdt.commit(conn);
		} catch (DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(ErrorCode.IB01,e);
		}finally {
			jdt.close(conn);
		}
	}
	
	public Map<String,Object> selectBoardDetail(int bdIdx){
		Map<String,Object> commandMap = new HashMap<String,Object>();
		Connection conn = jdt.getConnection();
		
		try {
			
			Board board = boardDao.selectBoardDetail(conn, bdIdx);
			List<FileVo> fileList = boardDao.selectFileWithBoard(conn, bdIdx);
			commandMap.put("board", board);
			commandMap.put("fileList", fileList);
			
		} catch (SQLException e) { 
			jdt.close(conn);
			throw new DataAccessException(ErrorCode.SM01, e);
		}
		return commandMap;
		
	}
	
	public void updateBoard(Board board) {
		Connection conn = jdt.getConnection();
		
		try {
			boardDao.updateBoard(conn, board);
			
			jdt.commit(conn);
		}catch (Exception e) {
			jdt.rollback(conn);
			throw new DataAccessException(ErrorCode.SM01, e);
		}finally {
			jdt.close(conn);
		}
	}
	
	public List<Board> selectBoardInfo(){
		
		Connection conn = jdt.getConnection();
		List<Board> bList = null;
		try {
			bList  = boardDao.selectBoardInfo(conn);
		} finally {
			jdt.close(conn);
		}
		return bList;	
		
	}
	
	public Board selectByIdx(int idx) {
		Connection conn = jdt.getConnection();
		Board board = new Board();
		try {
			board = boardDao.selectByIdx(conn, idx);
		}finally {
			jdt.close(conn);
		}
		return board;
	}
}
