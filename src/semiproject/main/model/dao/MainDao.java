/*
 * package semiproject.main.model.dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException;
 * 
 * import semiproject.common.code.ErrorCode; import
 * semiproject.common.exception.DataAccessException; import
 * semiproject.common.template.JDBCTemplate; import
 * semiproject.find.model.vo.Listener;
 * 
 * public class MainDao {
 * 
 * JDBCTemplate jdt = JDBCTemplate.getInstance();
 * 
 * // 예약건수 랭킹 public Listener selectByResCnt(Connection conn) {
 * 
 * Listener listener = null; PreparedStatement pstm = null; ResultSet rset =
 * null; String sql =
 * "select * from (select LIST_PRO,LIST_FIELD,LIST_TYPE,LIST_NAME,\r\n" +
 * "LIST_RES_CNT, rank() over(order by LIST_RES_CNT desc) as res from tb_listener) where res = 1"
 * ;
 * 
 * try { pstm = conn.prepareStatement(sql); rset = pstm.executeQuery();
 * 
 * if(rset.next()) { listener = new Listener();
 * listener.setListPro(rset.getString(1));
 * listener.setListField(rset.getString(2));
 * listener.setListType(rset.getString(3));
 * listener.setListName(rset.getString(4));
 * listener.setListResCnt(rset.getInt(5)); }
 * 
 * } catch (SQLException e) { throw new DataAccessException(ErrorCode.SL01, e);
 * }finally { jdt.close(rset,pstm); }
 * 
 * return listener; }
 * 
 * }
 */