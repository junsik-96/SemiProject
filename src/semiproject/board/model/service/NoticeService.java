package semiproject.board.model.service;

import java.sql.Connection;
import java.util.List;

import semiproject.board.model.dao.NoticeDao;
import semiproject.board.model.vo.Board;
import semiproject.board.model.vo.Notice;
import semiproject.common.template.JDBCTemplate;

public class NoticeService {
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	NoticeDao noticeDao = new NoticeDao();
	
	public List<Notice> selectNoticeList(){
		
		Connection conn = jdt.getConnection();
		List<Notice> nList = null;
		try {
			nList  = noticeDao.selectNoticeList(conn);
		} finally {
			jdt.close(conn);
		}
		return nList;		
	}
	
	public Notice selectByIdx(int idx) {
		Connection conn = jdt.getConnection();
		Notice notice = new Notice();
		try {
			notice = noticeDao.selectByIdx(conn, idx);
		}finally {
			jdt.close(conn);
		}
		return notice;
	}
	
}
