package semiproject.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import semiproject.board.model.dao.DiaryDao;
import semiproject.board.model.vo.Diary;
import semiproject.board.model.vo.Notice;
import semiproject.common.exception.DataAccessException;
import semiproject.common.exception.ToAlertException;
import semiproject.common.template.JDBCTemplate;
import semiproject.common.util.file.FileUtil;
import semiproject.common.util.file.FileVo;

public class DiaryService {
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	DiaryDao diaryDao = new DiaryDao();
	
	public void insertDiary(String userId,HttpServletRequest request) {
		Connection conn = jdt.getConnection();
		
		Map<String,List> diaryData = new FileUtil().fileUpload(request);
		Diary diary = new Diary();
		diary.setUserId(userId);
		
		diary.setTitle(diaryData.get("title").get(0).toString());
		diary.setContent(diaryData.get("content").get(0).toString());
		
	
		try {
			diaryDao.insertDiary(conn, diary);
			List<FileVo> files = diaryData.get("fileData");
			for(FileVo fileVo : files) {
				diaryDao.insertFile(conn, fileVo);
			}
			jdt.commit(conn);
		} catch (DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error,e);
		}finally {
			jdt.close(conn);
		}
	}
	
	public List<Diary> selectDiaryList(String userId){
		
		Connection conn = jdt.getConnection();
		List<Diary> dList = null;
		try {
			dList  = diaryDao.selectDiaryList(conn, userId);
		} finally {
			jdt.close(conn);
		}
		return dList;		
	}
	
	public Diary selectByIdx(int idx) {
		Connection conn = jdt.getConnection();
		Diary diary = new Diary();
		try {
			diary = diaryDao.selectByIdx(conn, idx);
		}finally {
			jdt.close(conn);
		}
		return diary;
	}
	
	

}
