package semiproject.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import semiproject.board.model.dao.BoardDao;
import semiproject.board.model.vo.Board;
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
		board.setField(boardData.get("concern").get(0).toString());
	
		try {
			boardDao.insertBoard(conn, board);
			List<FileVo> files = boardData.get("fileData");
			for(FileVo fileVo : files) {
				boardDao.insertFile(conn, fileVo);
			}
			jdt.commit(conn);
		} catch (DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error,e);
		}finally {
			jdt.close(conn);
		}
	}
	
	public Map<String,Object> selectBoardDetail(String bdIdx){
		Map<String,Object> commandMap = new HashMap<String,Object>();
		Connection conn = jdt.getConnection();
		
		try {
			
			Board board = boardDao.selectBoardDetail(conn, bdIdx);
			List<FileVo> fileList = boardDao.selectFileWithBoard(conn, bdIdx);
			commandMap.put("board", board);
			commandMap.put("fileList", fileList);
			
		} catch (SQLException e) { 
			jdt.close(conn);
		}
		return commandMap;
		
	}
}
