/*
 * package semiproject.main.model.service;
 * 
 * import java.sql.Connection; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import semiproject.common.template.JDBCTemplate; import
 * semiproject.find.model.vo.Listener; import
 * semiproject.main.model.dao.MainDao;
 * 
 * public class MainService {
 * 
 * JDBCTemplate jdt = JDBCTemplate.getInstance(); MainDao mainDao = new
 * MainDao();
 * 
 * public List<Listener> selectByResCnt() {
 * 
 * List<Listener> listenerList = new ArrayList<Listener>(); Connection conn =
 * jdt.getConnection();
 * 
 * try { Listener listener = mainDao.selectByResCnt(conn);
 * listenerList.add(listener); }finally { jdt.close(conn); }
 * 
 * 
 * return listenerList; }
 * 
 * }
 */