package semiproject.index.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semiproject.common.template.JDBCTemplate;
import semiproject.find.model.vo.Listener;
import semiproject.index.model.dao.IndexDao;

public class IndexService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	IndexDao indexDao = new IndexDao();
	
	public List<Listener> selectByResCnt() {
		
		List<Listener> listenerList = new ArrayList<Listener>();
		Connection conn = jdt.getConnection();
		
		try {
			Listener listener = indexDao.selectByResCnt(conn);
			listenerList.add(listener);
		}finally {
			jdt.close(conn);
		}
		 
		
		return listenerList;
	}
	
}
